package jdbc;

import java.sql.*;

public class DemoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        //url,user,password
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root",
                "123456");
        //mysql执行
        Statement statement = connection.createStatement();
        String sql = "select * from student";
        //结果集对象
        ResultSet rs = statement.executeQuery(sql);
        //遍历ResultSet获取数据
        while (rs.next()) {
            String sno = rs.getString(1);
            String sname = rs.getString(2);
            String ssex = rs.getString(3);
            int sage = rs.getInt(4);
            String sdept = rs.getString(5);
            System.out.println(sno + "," + sname + "," + ssex + "," + sage + "," + sdept);

        }
        System.out.println(connection);
        rs.close();
        statement.close();
        //关闭connection
        connection.close();
    }
}
