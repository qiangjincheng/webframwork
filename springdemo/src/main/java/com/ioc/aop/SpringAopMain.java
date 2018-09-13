package com.ioc.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAopMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app3Context.xml");
        AopService aopService = (AopService) context.getBean("aopService");
        aopService.login();
    }
}
