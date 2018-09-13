package com.ioc.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class UserServiceHandler implements InvocationHandler {
   //被代理对象
    private UserService proxied;

    public UserServiceHandler(UserService proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       /* System.out.println("log ");
        System.out.println("check permission");*/
        Connection connection = (Connection) args[0];
        connection.setAutoCommit(false);
        Object result=null;
        try{
            //此处执行的真正的业务逻辑
            result=method.invoke(proxied,args);
            connection.commit();
        }catch (Exception e){
            connection.rollback();
        }finally {
            connection.close();
        }
        return result;
      /*  System.out.println("free resource");
        return result;*/
    }
}
