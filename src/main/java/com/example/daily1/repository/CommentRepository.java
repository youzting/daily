package com.example.daily1.repository;

import com.example.daily1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Long countByDailyId(Long dailyId);
}
