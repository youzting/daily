package com.example.daily1.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentGetResponse {
    private final Long id;
    private final String content;
    private final String commenter;
    private final LocalDateTime createdAt;
    private final LocalDateTime updateAt;

    public CommentGetResponse(Long id, String content, String commenter, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.content = content;
        this.commenter = commenter;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
}
