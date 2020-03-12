package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminLoginLog {

	private Integer log_id;
	private String amin_account;
	private String login_time;
	private String login_ip;

}
