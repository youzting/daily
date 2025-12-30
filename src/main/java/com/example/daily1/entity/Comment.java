package com.example.daily1.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String commenter;
    private String commentpass;

    public Comment(String content, String commenter, String password, Daily daily) {
        this.content = content;
        this.commenter = commenter;
        this.commentpass = password;
        this.daily = daily;
    }

    @ManyToOne(fetch = FetchType.LAZY)//여러개의 댓글이 하나의 일정에 속한다. LAZY는 필요할 대 가져오는 방식
    @JoinColumn(name="daily_id")
    private Daily daily;
}
