package com.zhiyou100.homework;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*@ClassName:MybatisDemo
 @Description:TODO
 @Author:
 @Date:2018/9/4 16:23
 @Version:v1.0
*/
/*  mybatis是一款优秀的持久层框架，它支持定制化sql,存储过程以及高级映射
* */
public class MybatisDemo {
    //mybatis配置文件路径

    public static SqlSessionFactory sqlSessionFactory;
    static {
        String resource ="mybatis-config.xml";
        InputStream inputStream=null;
        try {
            inputStream= Resources.getResourceAsStream(resource);
            //创建一个sqlSessionFactory对象，用来获取sqlSession
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        //testFindById();
        //testInsert();
        //testInsertMap();
        //testFindByIdToMap();
        //testStudentFindById();
        testOneToMany();
        //testSelectByMap();


    }

    private static void testSelectByMap() {
        SqlSession session = sqlSessionFactory.openSession();
        //获取mapper mapper 是dao的实现
        PersonDao personDao = session.getMapper(PersonDao.class);
        Map<Object, Object> map = new HashMap();
        map.put("id",1);
        map.put("name","tom");
        List<Person> personList = personDao.findByMap(map);
        System.out.println(personList);
    }

    private static void testInsertMap() {
        SqlSession session = sqlSessionFactory.openSession();
        PersonDao personDao = session.getMapper(PersonDao.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id",6);
        map.put("name","dle");
        personDao.insertByMap(map);
        session.commit();
        session.close();
    }

    private static void testFindByIdToMap() {
        //打开一个会话
        SqlSession session = sqlSessionFactory.openSession();
        //获取mapper mapper 是dao的实现
        PersonDao personDao = session.getMapper(PersonDao.class);
        Map map = personDao.findByIdToMap(1);
        System.out.println(map);
    }

    private static void testInsert() {

        SqlSession session = sqlSessionFactory.openSession();
        //获取mapper mapper 是dao的实现
        PersonDao personDao = session.getMapper(PersonDao.class);
        personDao.insert(new Person(4, "12"));
        session.commit();

    }

    private static void testOneToMany() {
        SqlSession session = sqlSessionFactory.openSession();
        GradeDao gradeDao = session.getMapper(GradeDao.class);
        Grade grade = gradeDao.findById(1);
        System.out.println(grade);
    }

    private static void testStudentFindById() {
        SqlSession session = sqlSessionFactory.openSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Student student = studentDao.findById(1);
        System.out.println(student);
    }

    private static void testFindById() {
        //打开一个会话
        SqlSession session = sqlSessionFactory.openSession();
        //获取mapper mapper 是dao的实现
        PersonDao personDao = session.getMapper(PersonDao.class);
        Person person1 = personDao.findById(1);
        System.out.println(person1);

    }
}
