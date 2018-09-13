package com.zhiyou100.auto.entity;

import lombok.Data;

@Data
public class RolePermission {
    private int id;
    private int rid;
    private int pid;
    private Permission permission;
    private Role role;
}
