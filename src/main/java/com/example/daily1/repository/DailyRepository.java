package com.example.daily1.repository;

import com.example.daily1.entity.Daily;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyRepository extends JpaRepository<Daily, Long> {

    List<Daily> findByNameOrderByUpdateAtDesc(String name);

    List<Daily> findAllByOrderByUpdateAtDesc();
}
