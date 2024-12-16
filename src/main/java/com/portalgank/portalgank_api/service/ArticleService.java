package com.portalgank.portalgank_api.service;

import com.portalgank.portalgank_api.entity.Article;
import com.portalgank.portalgank_api.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")  );
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(Long id, Article updatedArticle) {
        Article existingArticle = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("User does not exists"));

        existingArticle.setTitle(updatedArticle.getTitle());
        existingArticle.setContent(updatedArticle.getContent());
        existingArticle.setImage(updatedArticle.getImage());

        return articleRepository.save(existingArticle);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
