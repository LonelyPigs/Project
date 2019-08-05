package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentOperator implements StudentOperatable {
    @Override
    public List<Student> findAllStudent() {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;
        ResultSet rs = null;
        List<Student> studentList = new ArrayList<>();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "select * from student";
        try {
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String sno = rs.getString(1);
                String sname = rs.getString(2);
                String ssex = rs.getString(3);
                int sage = rs.getInt(4);
                String sdept = rs.getString(5);

                Student student = new Student();
                student.setSno(sno);
                student.setSname(sname);
                student.setSsex(ssex);
                student.setSage(sage);
                student.setSdept(sdept);
                studentList.add(student);
            }
            studentList.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return studentList;
    }

    @Override
    public int updateStudentById(Student student) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "update student set where sno=" + student.getSno();
            int affectedRows = statement.executeUpdate(sql);
            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return 0;
    }

    @Override
    public int insertStudent(Student student) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("insert into student values(null,");
            stringBuffer.append("'");
            stringBuffer.append(student.getSno());
            stringBuffer.append("','");
            stringBuffer.append(student.getSname());
            stringBuffer.append("','");
            stringBuffer.append(student.getSsex());
            stringBuffer.append("',");
            stringBuffer.append(student.getSage());
            stringBuffer.append(",'");
            stringBuffer.append(student.getSdept());
            stringBuffer.append("')");

            int affectedRows = statement.executeUpdate(stringBuffer.toString());
            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return 0;
    }

    @Override
    public int deleteStudentById(String sno) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "delete from student where sno=" + sno;

            int affectedRows = statement.executeUpdate(sql);
            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return 0;
    }
}
