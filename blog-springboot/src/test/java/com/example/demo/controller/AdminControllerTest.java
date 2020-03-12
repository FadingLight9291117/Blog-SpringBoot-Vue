package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminControllerTest {

    @Autowired
    AdminController adminController;

    @Test
    void loginCheck() {
        System.out.println(adminController.loginCheck("123456@q.com", "m4a421"));
    }

    @Test
    void getInformation() {
        System.out.println(adminController.getInformation("123456@qq.com"));
    }
}