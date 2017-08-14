package com.yunseul.api.repository;

import com.yunseul.api.repository.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
