package com.example.demo.service.impl;

import java.util.Objects;

import com.example.demo.entity.Admin;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.service.AdminService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private SqlSession sqlSession;

	// 测试成功
	@Override
	public Boolean updatePwd(String account, String password) {
		return sqlSession.getMapper(AdminMapper.class).updatePwd(account, password) > 0;
	}

	// 测试成功
	@Override
	public Admin getByAccount(String account) {
		return sqlSession.getMapper(AdminMapper.class).getAdminByAccount(account);
	}

	public Boolean logincheck(String account, String password) {
		return null;
	}
}
