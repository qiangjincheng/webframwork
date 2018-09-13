package com.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration//表示测试的是controller
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mvc.xml"})
public class LoginControllerTest {
    @Autowired
    WebApplicationContext wac;
    //controller 测试核心类 mock：模拟
    MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void loginError() throws Exception {
        mockMvc.perform(post("/login/login.do").param("username","zhangsan"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("error"));
    }
    @Test
    public void loginSuccess() throws Exception {
        mockMvc.perform(post("/login/login.do")
                .param("username","zhangsan")
                .param("password","123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(request().sessionAttribute("user","zhangsan"))
                .andExpect(view().name("success"));

    }

}