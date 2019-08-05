package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlOperator{
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection=null;
        ResultSet rs=null;
        Statement statement=null;

        List<Student> studentList=new ArrayList<>();

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root",
                    "123456");
            statement = connection.createStatement();
            String sql = "select * from student";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String sno = rs.getString(1);
                String sname = rs.getString(2);
                String ssex = rs.getString(3);
                int sage = rs.getInt(4);
                String sdept = rs.getString(5);

                Student student=new Student();
                student.setSno(sno);
                student.setSname(sname);
                student.setSsex(ssex);
                student.setSage(sage);
                student.setSdept(sdept);

                studentList.add(student);

            }
            studentList.forEach(System.out::println);

            //操作student表中数据


        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            closeResource(rs);
            closeResource(statement);
            closeResource(connection);
        }
    }
    public static void closeResource(AutoCloseable autoCloseable){
        if(null!=autoCloseable){
            try {
                autoCloseable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
