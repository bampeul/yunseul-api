package com.yunseul.api.repository;

import com.yunseul.api.repository.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
