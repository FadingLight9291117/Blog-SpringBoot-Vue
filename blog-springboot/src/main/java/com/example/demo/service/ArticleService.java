package com.example.demo.service;


import com.example.demo.entity.Article;

import java.util.List;

public interface ArticleService {

	Boolean addArticle(Article article);

	Boolean deleteArticleById(Integer article_id);

	Boolean updateArticle(Article article);

	List<Article> listAll();

	List<Article> listByPubDate();

	Article getById(Integer id);

}
