package com.ioc.aop;

import org.springframework.stereotype.Service;

@Service
public class AopService {
    public void login(){
        System.out.println("do login");
    }
}
