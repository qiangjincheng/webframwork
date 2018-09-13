package com.zhiyou100.homework;

import lombok.Data;

import java.util.List;

@Data
public class Grade {
    private int id;
    private String name;
    /*表示一对多*/
    private List<Student> studentList;
}
