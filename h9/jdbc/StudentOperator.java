package homework.h9.jdbc;

import homework.h9.transaction.JdbcUtil;
import jdbc.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentOperator implements StudentOperatable {

    @Override
    public List<Student> findByIdLike(String sno) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> stuList = new ArrayList<>();

        String sql = "select * from student where sno like ?";// PreparedStatement 所执行的sql语句,模糊查找
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, sno);// 占位符赋值
            rs = ps.executeQuery();

            //遍历结果集
            while (rs.next()) {
                String snoo = rs.getString(1);
                String sname = rs.getString(2);
                String ssex = rs.getString(3);
                int sage = rs.getInt(4);
                String sdept = rs.getString(5);

                // 向stuList填充数据
                Student student = new Student();
                student.setSno(snoo);
                student.setSname(sname);
                student.setSsex(ssex);
                student.setSage(sage);
                student.setSdept(sdept);
                stuList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(ps);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return stuList;
    }

    @Override
    public List<Student> findOrderByField(String field) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> stuList = new ArrayList<>();

        String sql = "select * from student order by ? desc";// PreparedStatement 所执行的sql语句，根据指定字段降序排序
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, field);// 占位符赋值
            rs = ps.executeQuery();

            //遍历结果集
            while (rs.next()) {
                String snoo = rs.getString(1);
                String sname = rs.getString(2);
                String ssex = rs.getString(3);
                int sage = rs.getInt(4);
                String sdept = rs.getString(5);

                // 向stuList填充数据
                Student student = new Student();
                student.setSno(snoo);
                student.setSname(sname);
                student.setSsex(ssex);
                student.setSage(sage);
                student.setSdept(sdept);
                stuList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(ps);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return stuList;
    }

    @Override
    public List<Student> findByIdLikeOrderLimit(String sno, int currPage, int pageSize) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> stuList = new ArrayList<>();

        // PreparedStatement 所执行的sql语句，根据学号字段模糊查询，并设定分页
        String sql = "select * from student where sno like ? order by sno asc limit ?,? ";
        try {
            ps = connection.prepareStatement(sql);
            // 占位符赋值
            ps.setString(1, sno);
            ps.setInt(2, (currPage - 1) * pageSize);
            ps.setInt(3, pageSize);
            rs = ps.executeQuery();

            //遍历结果集
            while (rs.next()) {
                String snoo = rs.getString(1);
                String sname = rs.getString(2);
                String ssex = rs.getString(3);
                int sage = rs.getInt(4);
                String sdept = rs.getString(5);

                // 向stuList填充数据
                Student student = new Student();
                student.setSno(snoo);
                student.setSname(sname);
                student.setSsex(ssex);
                student.setSage(sage);
                student.setSdept(sdept);
                stuList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(ps);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return stuList;
    }
}
