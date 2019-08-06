package homework.h9.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
    private static final JdbcUtil JDBC_UTIL = new JdbcUtil();

    private JdbcUtil() {

    }

    JdbcUtil jdbcUtil = null;

    public static JdbcUtil getInstance() {
        return JDBC_UTIL;
    }

    /**
     * 获取连接
     * @return
     */
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root",
                    "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭连接
     * @param autoCloseable
     */
    public void closeResource(AutoCloseable autoCloseable) {
        if (null != autoCloseable) {
            try {
                autoCloseable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
