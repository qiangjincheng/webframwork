package com.zhiyou100.transaction;

import com.zhiyou100.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

//junit4整合spring
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit4 spring的配置文件的地址
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class StudentServiceTest {
    /*@Resource(name ="")
    StudentService studentService;*/
    @Autowired
    StudentService studentService;

    @Test
    public void insertTwo() {
        studentService.insertTwo();
    }
}