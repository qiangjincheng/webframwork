package com.ioc.aop;

import org.springframework.stereotype.Component;


public class AopServiceAspect {
    public void before(){
        System.out.println("after method invoke");
        System.out.println("free resource");
    }
}
