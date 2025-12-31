package com.example.daily1.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "dailys")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Daily extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false, length = 200)
    private String text;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    //mappedBy= "daily": daily.getComments가 실행 되었을 때 DB에서 comments테이블을 FK(daily_id) 기준으로 조회한 뒤에 List<Comment >comments에 매핑한다
    //cascade daily에서의 저장,식제 행위가 comment에 같이 실행, orphanRemoval: daily와 연관관계가 끊긴 comment DB에서 제거
    @OneToMany(mappedBy = "daily", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Comment> comments = new ArrayList<>();

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
