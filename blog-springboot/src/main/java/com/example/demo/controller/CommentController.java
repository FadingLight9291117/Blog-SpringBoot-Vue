package com.example.demo.controller;


import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@ResponseBody
	@RequestMapping("/add")
	public Map<String, String> add(String id, String nickname, String content) {
		Comment comment = new Comment();
		comment.setArticle_id(Integer.parseInt(id));
		comment.setComm_content(content);
		comment.setComm_nickname(nickname);
		boolean b = commentService.add(comment);
		Map<String, String> map = new HashMap<>();
		if (b) {
			map.put("flag", "1");
		}
		else {
			map.put("flag", "0");
		}
		return map;
	}

	@RequestMapping("/list")
	public List<Comment> list(String id) {
		return commentService.listByAid(Integer.parseInt(id));
	}

}
