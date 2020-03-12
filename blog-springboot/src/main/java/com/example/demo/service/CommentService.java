package com.example.demo.service;

import com.example.demo.entity.Comment;

import java.util.List;


public interface CommentService {

	Boolean add(Comment comment);

	List<Comment> listByAid(Integer aid);

}
