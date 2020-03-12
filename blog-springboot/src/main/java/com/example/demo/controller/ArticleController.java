package com.example.demo.controller;

import com.example.demo.entity.Article;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/blog")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // 测试成功
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, String> addBlog(@RequestBody Map<String, String> map) {
        String title = map.get("title");
        String content = map.get("content");
        String date = map.get("date");
        String subject = map.get("subject");
        String classify = map.get("classify");
        String account = map.get("account");
        Article article = new Article();
        article.setClassify(classify);
        article.setDate(date);
        article.setContent(content);
        article.setSubject(subject);
        article.setTitle(title);
        article.setAccount(account);
        Map<String ,String> map1 = new HashMap<>();
        boolean b = articleService.addArticle(article);
        if (b)
            map1.put("flag", "1");
        return map1;
    }

    // 测试成功
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, String> updateBlog(@RequestBody Map<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        String title = map.get("title");
        String content = map.get("content");
        String date = map.get("date");
        String subject = map.get("subject");
        String classify = map.get("classify");
        String account = map.get("account");
        Article article = new Article();
        article.setClassify(classify);
        article.setDate(date);
        article.setContent(content);
        article.setSubject(subject);
        article.setTitle(title);
        article.setAccount(account);
        article.setId(id);
        Map<String ,String> map1 = new HashMap<>();
        boolean b = articleService.updateArticle(article);
        if (b)
            map1.put("flag", "1");
        return map1;
    }
    // 测试成功
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public Article queryBlog(@RequestBody Map<String, String> map) {
        return articleService.getById(Integer.parseInt(map.get("id")));
    }

    //测试成功
    @RequestMapping("/blogs")
    public List<Article> getBlogs() {
        return articleService.listAll();
    }

    @RequestMapping("/recommend")
    public List<Article> getRecommend() {
        return articleService.listAll().stream().limit(10).collect(Collectors.toList());
    }

    // 测试成功
    @RequestMapping("/delete")
    public Map<String, String> delete(@RequestParam("id") Integer id) {
        Map<String ,String> map = new HashMap<>();
        boolean b = articleService.deleteArticleById(id);
        if (b) {
            map.put("flag", "1");
        } else {
            map.put("flag", "0");
        }
        return map;
    }
}
