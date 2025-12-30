package com.example.daily1.service;

import com.example.daily1.dto.*;
import com.example.daily1.entity.Comment;
import com.example.daily1.entity.Daily;
import com.example.daily1.repository.CommentRepository;
import com.example.daily1.repository.DailyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyService {
    private final DailyRepository dailyRepository;
    private final CommentRepository commentRepository;

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

    @Transactional
    public CommentCreateResponse saveComment(Long dailyId, CommentCreateRequest request){
        Daily daily = dailyRepository.findById(dailyId).orElseThrow(
                () -> new IllegalStateException("일정이 없습니다.")
        );
        long count = commentRepository.countByDailyId(dailyId);
        if(count >= 10){
            throw new IllegalStateException("댓글은 10개까지");
        }

        Comment comment = new Comment(
                request.getContent(),
                request.getCommenter(),
                request.getCommentpass(),
                daily
        );

        Comment saveComent = commentRepository.save(comment);

        return new CommentCreateResponse(
                saveComent.getContent(),
                saveComent.getCommenter(),
                saveComent.getDaily().getId()
        );

    }

    @Transactional(readOnly = true)
    public List<DailyGetResponse> getAll(String name){
        List<Daily> dailys;

        if (name == null || name.isBlank()) {
            dailys = dailyRepository.findAllByOrderByUpdateAtDesc();
        } else {
            dailys = dailyRepository.findByNameOrderByUpdateAtDesc(name);
        }

        List<DailyGetResponse> dtos = new ArrayList<>();
        for (Daily daily : dailys) {
            DailyGetResponse dto = new DailyGetResponse(
                    daily.getId(),
                    daily.getTitle(),
                    daily.getText(),
                    daily.getName(),
                    daily.getCreatedAt(),
                    daily.getUpdateAt()
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
                daily.getName(),
                daily.getCreatedAt(),
                daily.getUpdateAt()
        );
    }

    @Transactional
    public DailyUpdateResponse update(Long dailyId, DailyUpdateRequest request){
        Daily daily = dailyRepository.findById(dailyId).orElseThrow(
                () -> new IllegalStateException("일정이 없습니다.")
        );
        if (!daily.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        daily.update(request.getTitle(), request.getName());
        return new DailyUpdateResponse(
                daily.getId(),
                daily.getTitle(),
                daily.getText(),
                daily.getName(),
                daily.getCreatedAt(),
                daily.getUpdateAt()
        );
    }

    @Transactional
    public void delete(Long dailyid, DailyDeleteRequest request){
        //비밀번호 검증을 위해 existsById 대신 findById사용
        Daily daily = dailyRepository.findById(dailyid).orElseThrow(
                () -> new IllegalStateException("일정이 없습니다.")
        );
        if (!daily.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        //이미 id로 조회했기 때문에 delete사용
        dailyRepository.delete(daily);
    }
}
