package com.ioc.annotation;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Data
@Component(value = "dog")
public class Animal {
    private String name;
    private int age;
}
