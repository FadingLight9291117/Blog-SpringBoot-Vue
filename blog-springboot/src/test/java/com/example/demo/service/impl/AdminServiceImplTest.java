package com.example.demo.service.impl;

import com.example.demo.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceImplTest {

    @Autowired
    AdminService adminService;

    @Test
    void getByAccount() {
        System.out.println(adminService.getByAccount("123456@qq.com"));
    }
}