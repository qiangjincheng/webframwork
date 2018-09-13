package com.ioc.aop;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserService {
    int add(Connection conn) throws SQLException;
    int delete();
    int update();
}
