package com.example.demo.service;

import com.example.demo.entity.Admin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



public interface AdminService {

	Boolean updatePwd(String account, String password);

	Admin getByAccount(String account);

	Boolean logincheck(String account, String password);

}
