package com.ioc.annotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Person {
    @Autowired
    private Animal pet;
}
