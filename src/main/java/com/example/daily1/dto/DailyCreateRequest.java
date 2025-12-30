package com.example.daily1.dto;

import lombok.Getter;

@Getter
public class DailyCreateRequest {
    private String title;
    private String text;
    private String name;
    private String password;
}
