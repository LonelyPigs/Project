package com.train.day18;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        List<Student> studentList = new ArrayList<>();

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            // url：数据库连接地址 ://localhost:3306/test
            String url = "jdbc:mysql://localhost:3306/test";
            //user：连接数据库的用户名
            String user = "root";
            // password：连接数据库的密码
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
            //输出连接对象，只要不为null，就不是可以正常获取数据库连接
            System.out.println(connection);
            //根据Connection获取用于执行sql语句的语句对象（statement）
            statement = connection.createStatement();
            String sql = "select * from student";
            //执行查询后，会返回结果集对象：ResultSet，用完之后必须关闭
            rs = statement.executeQuery(sql);
            //遍历结果集
            while (rs.next()) {
                /**
                 * rs.next()：没执行一次，就会切换到下一行，直到结束
                 *
                 * 依次获取每一行每一列的数据
                 *      根据列索引获取数据：从1开始
                 *      根据名称获取数据：和数据库的列名一致
                 */
                String sno = rs.getString(1);
                String sname = rs.getString(2);
                String ssex = rs.getString(3);
                int sage = rs.getInt(4);
                String sdepart = rs.getString(5);
                System.out.println(sno + " , " + sname + " , " + ssex + " , " + sage + " , " + sdepart);

                Student stu = new Student();
                stu.setsNo(sno);
                stu.setsName(sname);
                stu.setsSex(ssex);
                stu.setsAge(sage);
                stu.setsDepart(sdepart);
                System.out.println(stu.toString());
                studentList.add(stu);

            }
            //
            studentList.forEach(System.out::println);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResource(rs);
            closeResource(statement);
            closeResource(connection);
        }
    }

    //资源用完之后必须关闭：后打开，先关闭，
    public static void closeResource(AutoCloseable res) {
        if(res != null){
            try {
                res.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
