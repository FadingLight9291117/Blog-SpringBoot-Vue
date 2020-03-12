package com.example.demo.mapper;


import com.example.demo.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

	@Insert("INSERT INTO COMMENT (COMM_NICKNAME, COMM_CONTENT, COMM_TIME, ARTICLE_ID) VALUES (#{comm_nickname}, #{comm_content}, #{comm_time}, #{article_id})")
	Integer addComment(Comment comment);

	@Select("SELECT * FROM COMMENT WHERE ARTICLE_ID = #{aid}")
	List<Comment> listComment(Integer aid);

}
