package com.zhiyou100.service;

import com.zhiyou100.dao.StudentMapper;
import com.zhiyou100.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("ss")
public class StudentService {
    @Autowired
    StudentMapper studentDao;
    public Student findById(int id){
        Student student = studentDao.selectByPrimaryKey(id);
        return student;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertTx(){
        Student s1 = new Student();
        s1.setAge(1200);
        s1.setName("qq");
        Student s2 = new Student();
        s2.setAge(1200);
        s2.setName("qqq");
        studentDao.insert(s1);

        studentDao.insert(s2);
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertP1(){
        Student s1 = new Student();
        s1.setAge(1200);
        s1.setName("qq");
        Student s2 = new Student();
        s2.setAge(1200);
        s2.setName("qqq");
        studentDao.insert(s1);

        insertTx();
        System.out.println(1/0);
    }



}
