package com.example.daily1.controller;

import com.example.daily1.dto.DailyCreateRequest;
import com.example.daily1.dto.DailyCreateResponse;
import com.example.daily1.dto.DailyGetResponse;
import com.example.daily1.service.DailyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DailyController {

    private final DailyService dailyService;

    @PostMapping("/dailys")
    public ResponseEntity<DailyCreateResponse> create(@RequestBody DailyCreateRequest request) {
        DailyCreateResponse result = dailyService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/dailys")
    public ResponseEntity<List<DailyGetResponse>> getAll(@RequestParam(required = false) String name) {//Query parameter로 name 값으로 조회 가능
        List<DailyGetResponse> result = dailyService.getAll(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/dailys/{dailysId}")
    public ResponseEntity<DailyGetResponse> getById(@PathVariable Long dailysId) {
        DailyGetResponse result = dailyService.getOne(dailysId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
