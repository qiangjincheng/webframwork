package com.zhiyou100.auto.entity;

import lombok.Data;

import java.util.List;

@Data
public class Permission {
    private int id;
    private List<Role> roleList;
    private String name;
}
