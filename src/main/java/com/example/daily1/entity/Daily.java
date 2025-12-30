package com.example.daily1.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "dailys")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Daily extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
    private String name;
    private String password;

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
