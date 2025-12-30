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

    @PostMapping("/dailys/{dailysId}/comments")
    public ResponseEntity<CommentCreateResponse> createComment(@PathVariable Long dailysId, @RequestBody CommentCreateRequest request) {
        CommentCreateResponse result = dailyService.saveComment(dailysId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/dailys")
    public ResponseEntity<List<DailyGetResponse>> getAll(@RequestParam(required = false) String name) {//Query parameter로 name 값으로 조회 가능
        List<DailyGetResponse> result = dailyService.getAll(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/dailys/{dailysId}")
    public ResponseEntity<DailyGetResponse> getById(@PathVariable("dailysId") Long dailysId) {
        DailyGetResponse result = dailyService.getOne(dailysId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/dailys/{dailysId}")
    public ResponseEntity<DailyUpdateResponse> update(@PathVariable("dailysId") Long dailysId, @RequestBody DailyUpdateRequest request) {
        DailyUpdateResponse result = dailyService.update(dailysId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/dailys/{dailysId}")
    public ResponseEntity<Void> delete(@PathVariable("dailysId") Long dailysId, @RequestBody DailyDeleteRequest request) {
        dailyService.delete(dailysId, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
