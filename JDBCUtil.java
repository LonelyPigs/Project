package com.train.day18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    private static final JDBCUtil JDBC_UTIL = new JDBCUtil();

    public JDBCUtil(){

    }

    public static JDBCUtil getInstance(){
        return JDBC_UTIL;
    }

    public Connection getConnection(){
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        //获取连接
        // url：数据库连接地址 ://localhost:3306/test
        String url = "jdbc:mysql://localhost:3306/test";
        //user：连接数据库的用户名
        String user = "root";
        // password：连接数据库的密码
        String password = "root";
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //资源用完之后必须关闭：后打开，先关闭，
    public void closeResource(AutoCloseable res) {
        if(res != null){
            try {
                res.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
