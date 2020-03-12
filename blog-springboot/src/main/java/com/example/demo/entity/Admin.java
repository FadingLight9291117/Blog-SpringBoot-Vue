package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

	private String admin_account;
	private String nickname;
	private String password;
	private String sex;
	private Integer age;
	private Integer phone;
	private Long qq_number;
	private String motto;
	private String headpic;
	
}
