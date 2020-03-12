package com.example.demo.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

	private Integer comm_id;
	private Integer article_id;
	private String comm_nickname;
	private String comm_content;
	private String comm_time;
	private String comm_email;
	private String comm_headpic;

}
