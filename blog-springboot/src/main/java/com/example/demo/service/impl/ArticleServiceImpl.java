package com.example.demo.service.impl;

import com.example.demo.entity.Article;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.service.ArticleService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private  SqlSession sqlSession;

    // 测试成功
    @Override
    public Boolean addArticle(Article article) {

        return sqlSession.getMapper(ArticleMapper.class).addArticle(article) > 0;
    }

    // 测试成功
    @Override
    public Boolean deleteArticleById(Integer id) {
        return sqlSession.getMapper(ArticleMapper.class).deleteArticleById(id) > 0;
    }

    // 测试成功
    @Override
    public Boolean updateArticle(Article article) {
        return sqlSession.getMapper(ArticleMapper.class).updateArticle(article) > 0;
    }

    // 测试成功
    @Override
    public List<Article> listAll() {
        return sqlSession.getMapper(ArticleMapper.class).listArticleAll();
    }

    @Override
    public List<Article> listByPubDate() {
        return null;
    }

    // 测试成功
    @Override
    public Article getById(Integer id) {
        return sqlSession.getMapper(ArticleMapper.class).getArticleById(id);
    }
}
