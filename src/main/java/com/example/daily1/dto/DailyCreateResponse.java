package com.example.daily1.dto;

import lombok.Getter;

@Getter
public class DailyCreateResponse {
    private final String title;
    private final String text;
    private final String name;


    public DailyCreateResponse(String title, String text, String name) {
        this.title = title;
        this.text = text;
        this.name = name;

    }
}
