package com.zhiyou100.auto.entity;

import lombok.Data;

@Data
public class Role {
    private int id;
    private String name;
    private Permission permission;
}
