package com.portalgank.portalgank_api.repository;

import com.portalgank.portalgank_api.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
