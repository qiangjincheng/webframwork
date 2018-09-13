package com.ioc.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app2Context.xml");
        Animal animal = (Animal) context.getBean("dog");
        Animal animal2 = context.getBean(Animal.class);
        System.out.println(animal);
        System.out.println(animal2);
        System.out.println(animal==animal2);
        animal.setName("tom");
        System.out.println(animal2.getName());

        //
        Person person = context.getBean(Person.class);
        System.out.println(person.getPet().getName());
    }
}
