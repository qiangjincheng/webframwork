package aop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    public int add(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into t_user values (2,'aop',123)");
        int rows = ps.executeUpdate();
        //System.out.println("add a user");
        return rows;
    }

    public int delete() {
        System.out.println("delete a user");
        return 0;
    }

    public int update() {
        System.out.println("update");
        return 0;
    }
}
