package com.example.daily1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Daily1Application {

    public static void main(String[] args) {
        SpringApplication.run(Daily1Application.class, args);
    }

}
