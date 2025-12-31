package com.example.daily1.controller;

import com.example.daily1.dto.*;
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

    @PostMapping("/dailys/{dailyId}/comments")
    public ResponseEntity<CommentCreateResponse> createComment(@PathVariable Long dailyId, @RequestBody CommentCreateRequest request) {
        CommentCreateResponse result = dailyService.saveComment(dailyId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/dailys")
    public ResponseEntity<List<DailyGetResponse>> getAll(@RequestParam(required = false) String name) {//Query parameter로 name 값으로 조회 가능(필수 아님)
        List<DailyGetResponse> result = dailyService.getAll(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/dailys/{dailyId}")
    public ResponseEntity<DailyGetOneResponse> getOne(@PathVariable("dailyId") Long dailyId) {
        DailyGetOneResponse result = dailyService.getOne(dailyId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/dailys/{dailyId}")
    public ResponseEntity<DailyUpdateResponse> update(@PathVariable("dailyId") Long dailyId, @RequestBody DailyUpdateRequest request) {
        DailyUpdateResponse result = dailyService.update(dailyId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/dailys/{dailyId}")
    public ResponseEntity<Void> delete(@PathVariable("dailyId") Long dailyId, @RequestBody DailyDeleteRequest request) {//password Request
        dailyService.delete(dailyId, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
