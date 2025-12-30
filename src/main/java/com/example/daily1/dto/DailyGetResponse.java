package com.example.daily1.dto;

public class DailyGetResponse {
    private Long id;
    private String title;
    private String text;
    private String name;

    public DailyGetResponse(Long id, String title, String text, String name) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.name = name;
    }
}
