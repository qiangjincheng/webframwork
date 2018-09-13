package com.ioc.aop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    public int add(Connection conn) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("delete from t_user where id=100");
        int rows = ps.executeUpdate();

        /*System.out.println("log");
        System.out.println("check permission");*/
        //System.out.println("add a user");
        return rows;
    }

    public int delete() {
        /*System.out.println("log");
        System.out.println("check permission");*/
        System.out.println("delete a user");
        return 0;
    }

    public int update() {
        System.out.println("update");
        return 0;
    }
}
