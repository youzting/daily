package com.example.daily1.dto;

import lombok.Getter;

@Getter
public class CommentCreateRequest {
    private String content;
    private String commenter;
    private String commentpass;
}
