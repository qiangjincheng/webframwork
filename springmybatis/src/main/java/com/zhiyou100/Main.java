package com.zhiyou100;

import com.zhiyou100.dao.StudentMapper;
import com.zhiyou100.entity.Student;
import com.zhiyou100.service.StudentService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        StudentMapper studentDao = context.getBean(StudentMapper.class);

        Student student = studentDao.selectByPrimaryKey(1);
        StudentService studentService = context.getBean(StudentService.class);
        //Student student1 = studentService.findById(1);

        //System.out.println(student1);
        System.out.println(student);

    }
}
