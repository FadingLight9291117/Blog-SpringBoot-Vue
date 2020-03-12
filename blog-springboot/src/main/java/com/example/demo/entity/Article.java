package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	private Integer id;
	private String account;
	private String title;
	private String classify;
	private String subject;
	private String content;
	private String date;
}
