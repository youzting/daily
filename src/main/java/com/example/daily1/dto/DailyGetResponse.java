package com.example.daily1.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class DailyGetResponse {
    private final Long id;
    private final String title;
    private final String text;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime updateAt;

    //전체 조회
    public DailyGetResponse(Long id, String title, String text, String name, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.name = name;
        this.createdAt = createdAt;
        this.updateAt = updateAt;

    }


}
