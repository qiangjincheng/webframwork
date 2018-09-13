package com.ioc.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
*   ioc(inverse of control):控制反转
*   1.程序中的bean写在Spring，将具体的配置写在xml中，由xml来控制
*   2.本来通过new来实例化对象，现在通过spring容器来实例化类的对象
* */

public class Main {
    public static void main(String[] args) {
        //初始化工厂
        //从classPath下的appliContext.xml文件中启动工厂
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("appContext.xml");
        //从工厂中获取对象
        Person tom = (Person) factory.getBean("tom");
        tom.sayHello();
        System.out.println(tom.getName());
        Person jack = (Person) factory.getBean("jack");
        jack.sayHello();
        System.out.println(jack==tom);

    }
}
