package com.zhiyou100.transaction;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.*;

@ContextConfiguration(locations = {"classpath:spring.xml"})
public class MutipleDataSourceStudentServiceTest {
    @Autowired
    MutipleDataSourceStudentService mutipleDataSourceStudentService;

    @Test
    public void test1() {
        mutipleDataSourceStudentService.test();
    }
}