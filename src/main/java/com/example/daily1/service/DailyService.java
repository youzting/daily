package com.example.daily1.service;

import com.example.daily1.dto.DailyCreateRequest;
import com.example.daily1.dto.DailyCreateResponse;
import com.example.daily1.dto.DailyGetResponse;
import com.example.daily1.entity.Daily;
import com.example.daily1.repository.DailyRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyService {
    private final DailyRepository dailyRepository;

    @Transactional
    public DailyCreateResponse save(DailyCreateRequest request){
        Daily daily = new Daily(
                request.getTitle(),
                request.getText(),
                request.getName(),
                request.getPassword()
        );
        Daily savedDaily = dailyRepository.save(daily);
        return new DailyCreateResponse(
                savedDaily.getTitle(),
                savedDaily.getText(),
                savedDaily.getName()
        );
    }

    @Transactional(readOnly = true)
    public List<DailyGetResponse> getAll(String name){
        List<Daily> dailys;

        if (name == null || name.isBlank()) {
            dailys = dailyRepository.findAllByOrderByUpdatedAtDesc();
        } else {
            dailys = dailyRepository.findByNameOrderByUpdatedAtDesc(name);
        }

        List<DailyGetResponse> dtos = new ArrayList<>();
        for (Daily daily : dailys) {
            DailyGetResponse dto = new DailyGetResponse(
                    daily.getId(),
                    daily.getTitle(),
                    daily.getText(),
                    daily.getName()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public DailyGetResponse getOne(Long dailyid){
        Daily daily = dailyRepository.findById(dailyid).orElseThrow(
                () -> new IllegalStateException("일정이 없습니다.")
        );
        return new DailyGetResponse(
                daily.getId(),
                daily.getTitle(),
                daily.getText(),
                daily.getName()
        );
    }
}
