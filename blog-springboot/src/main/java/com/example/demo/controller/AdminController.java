package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	// 测试成功
	@RequestMapping("/updatepwd")
	public Map<String, String> update(@RequestParam("account") String account, @RequestParam("newPassword") String newPassword) {
		Boolean flag = adminService.updatePwd(account, newPassword);
		Map<String, String> map = new HashMap<>();
		if (flag) {
			map.put("flag", "1");
		}
		return map;
	}

	// 测试成功
	@RequestMapping("/login")
	public	Map<String, String> loginCheck(String account, String password) {
		Map<String, String> map = new HashMap<>();
		Admin admin = adminService.getByAccount(account);
		if (admin == null) {
			map.put("flag", "0");
		}
		else {
			String rightPwd = admin.getPassword();
			boolean flag = rightPwd.equals(password);
			if (flag)
				map.put("flag", "1");
			else
				map.put("flag", "0");
		}
		return map;
	}

	// 测试成功
	@RequestMapping("/getInfo")
	public Admin getInformation(@RequestParam("account") String account) {
		return adminService.getByAccount(account);
	}


}
