package com.ioc.annotation;

public class SingletonTest {
    //volatile:内存可见性：当一个线程修改由volatile修饰的字段时，其他线程是可见的
    //保证一次写，多次读的线程安全，保证不了并发写的线程安全
    private static volatile SingletonTest instance=null;

    private SingletonTest(){

    }
    public static SingletonTest getInstance0(){
        if (instance==null){
            instance=new SingletonTest();
        }
        return instance;
    }
    public static SingletonTest getInstance1(){
        if (instance==null){
            //双重检查，保证线程安全
            synchronized (SingletonTest.class){
                if (instance==null){
                    instance=new SingletonTest();
                }
            }
        }
        return instance;
    }
    public static SingletonTest getInstance(){
        if (instance==null){
            instance=new SingletonTest();
        }
        return instance;
    }
}
