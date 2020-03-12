package com.example.demo.service.impl;

import com.example.demo.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceImplTest {

    @Autowired
    ArticleService articleService;
    @Test
    void getById() {
        System.out.println(articleService.getById(2));
    }

    @Test
    void deleteArticleById() {
        articleService.deleteArticleById(5);
    }
}