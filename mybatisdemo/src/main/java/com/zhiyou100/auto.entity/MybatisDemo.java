package com.zhiyou100.auto.entity;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

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

    public static void main(String[] args) {
        q1();
        //
        //q2();
    }

    private static void q2() {
        SqlSession session = sqlSessionFactory.openSession();
        PermissionDao permissionDao = session.getMapper(PermissionDao.class);
        Permission byId = permissionDao.findById(1);
        System.out.println(byId);
    }

    private static void q1() {
        SqlSession session = sqlSessionFactory.openSession();
        //获取mapper mapper 是dao的实现
        RoleDao roleDao = session.getMapper(RoleDao.class);
        Role byId = roleDao.findById(1);
        System.out.println(byId);

    }
}
