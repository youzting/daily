package com.example.daily1.dto;

import lombok.Getter;

@Getter
public class CommentCreateResponse {
    private final String content;
    private final String commenter;
    private final Long dailyId;

    public CommentCreateResponse(String content, String commenter,  Long dailyId) {
        this.content = content;
        this.commenter = commenter;
        this.dailyId = dailyId;
    }
}
