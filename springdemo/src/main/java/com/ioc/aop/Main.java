package com.ioc.aop;

import javax.xml.ws.Service;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ClassLoader loader = Main.class.getClassLoader();
        Class[] interfaces={UserService.class};
        UserServiceImpl proxied = new UserServiceImpl();
        UserService proxy = (UserService) Proxy.newProxyInstance(loader, interfaces, new UserServiceHandler(proxied));

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flat_cms", "root", "123");
        proxy.add(connection);
        /*proxy.add();
        proxy.delete();
        proxy.update();*/
    }
}
