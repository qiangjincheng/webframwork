package com.ioc.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*项目入口*/
public class Main {
    public static void main(String[] args) {
        //初始化工厂
        //从classPath下的appContext.xml文件中启动工厂
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("appContext.xml");
        //从工厂中获取对象
        Person tom = (Person) factory.getBean("tom");
        tom.sayHello();
        System.out.println(tom.getName());
        System.out.println(tom.getAge());
        Person jack = (Person) factory.getBean("jack");
        jack.sayHello();
        System.out.println(jack.getName());
        System.out.println(jack.getAge());

        Person rose = (Person) factory.getBean("rose");
        System.out.println(rose.getName());
        System.out.println(rose.getFriend().getName());
    }
}
