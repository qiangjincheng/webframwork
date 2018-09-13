package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*代理类就是在调用实现类的方法时，可以在方法执行前后做额外的工作*/
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //代理的类加载器，必须和被代理对象是一个类加载器
        ClassLoader loader = Main.class.getClassLoader();
        //代理对象要实现的那些接口
        Class[] interfaces={UserService.class};
        //指派方法调用的调用处理程序
        UserServiceImpl proxied = new UserServiceImpl();
        UserService proxy = (UserService) Proxy.newProxyInstance(loader, interfaces, new UserServiceHandler(proxied));
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flat_cms", "root", "123");
        proxy.add(connection);
        /*//proxy.add();
        proxy.delete();
        proxy.update();*/
    }
}
