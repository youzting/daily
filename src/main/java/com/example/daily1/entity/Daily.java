package com.example.daily1.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Enabled
@Table(name = "dailys")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Daily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
    private String name;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public Daily(String title, String text, String name, String password) {
        this.title = title;
        this.text = text;
        this.name = name;
        this.password = password;
    }

    public void update(String title, String name){
        this.title = title;
        this.name = name;
    }
}
