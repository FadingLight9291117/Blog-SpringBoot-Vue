package com.example.demo.service.impl;


import java.util.List;

import com.example.demo.entity.Comment;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.service.CommentService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public Boolean add(Comment comment) {
		if (comment != null) {
			int index = sqlSession.getMapper(CommentMapper.class).addComment(comment);
			return index > 0;
		}
		return null;
	}

	@Override
	public List<Comment> listByAid(Integer aid) {
		if (aid != null) {
			List<Comment> list = sqlSession.getMapper(CommentMapper.class).listComment(aid);
			if (list != null && list.size() != 0) {
				return list;
			}
		}
		return null;
	}

}
