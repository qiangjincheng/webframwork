package com.zhiyou100.transaction;

import com.zhiyou100.dao.StudentMapper;
import com.zhiyou100.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StudentService {
    @Autowired
    StudentMapper studentDao;
    public Student findById(int id){
        Student student = studentDao.selectByPrimaryKey(id);
        return student;
    }
    //表明该方法是事务方法
    @Transactional
    public void insertTwo(){
        Student jack = new Student();
        jack.setName("jack");
        jack.setAge(18);

        Student tom = new Student();
        tom.setAge(18);
        tom.setName("tom");

        studentDao.insert(jack);
        //insertTwo();
       // System.out.println(1/0);
        studentDao.insert(tom);
    }
    //@Transactional
    public void insertTwo2(){
        Student jack = new Student();
        jack.setName("jack");
        jack.setAge(18);

        Student tom = new Student();
        tom.setAge(18);
        tom.setName("tom");

        studentDao.insert(jack);
        insertTwo();
        System.out.println(1/0);
        studentDao.insert(tom);
    }
}

