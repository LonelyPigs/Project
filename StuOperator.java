package com.train.day18;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StuOperator implements StuOperatable {

    @Override
    public List<Student> findAllStu() {
        Connection conn = JDBCUtil.getInstance().getConnection();
        Statement state = null;
        ResultSet rs = null;
        List<Student> studentList = new ArrayList<>();
        try {
            state = conn.createStatement();
            String sql = "select * from student";
            rs = state.executeQuery(sql);
            //遍历结果集
            while (rs.next()) {
                /**
                 * rs.next()：没执行一次，就会切换到下一行，直到结束
                 *
                 * 依次获取每一行每一列的数据
                 *      根据列索引获取数据：从1开始
                 *      根据名称获取数据：和数据库的列名一致
                 */
                Student stu = new Student();
                stu.setsNo(rs.getString(1));
                stu.setsName(rs.getString(2));
                stu.setsSex(rs.getString(3));
                stu.setsAge(rs.getInt(4));
                stu.setsDepart(rs.getString(5));
                studentList.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.getInstance().closeResource(rs);
            JDBCUtil.getInstance().closeResource(state);
            JDBCUtil.getInstance().closeResource(conn);
        }
        return studentList;
    }

    @Override
    //增加
    public int insertStu(Student student) {

        Connection conn = JDBCUtil.getInstance().getConnection();
        Statement state = null;
        try {
            state = conn.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("insert into student values('");
            stringBuffer.append(student.getsNo());
            stringBuffer.append("','");
            stringBuffer.append(student.getsName());
            stringBuffer.append("','");
            stringBuffer.append(student.getsSex());
            stringBuffer.append("',");
            stringBuffer.append(student.getsAge());
            stringBuffer.append(",'");
            stringBuffer.append(student.getsDepart());
            stringBuffer.append("')");
            //返回受影响的行数
            int affectedRows = state.executeUpdate(stringBuffer.toString());
            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.getInstance().closeResource(state);
            JDBCUtil.getInstance().closeResource(conn);
        }
        return 0;
    }

    @Override
    //修改
    public int updateStu(Student student) {
        Connection conn = JDBCUtil.getInstance().getConnection();
        Statement state = null;
        try {
            state = conn.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("update student set sno = '");
            stringBuffer.append(student.getsNo());
            stringBuffer.append("',sname = '");
            stringBuffer.append(student.getsName());
            stringBuffer.append("',ssex = '");
            stringBuffer.append(student.getsSex());
            stringBuffer.append("',sage = ");
            stringBuffer.append(student.getsAge());
            stringBuffer.append(",sdepart = '");
            stringBuffer.append(student.getsDepart());
            stringBuffer.append("'");
            //返回受影响的行数
            int affectedRows = state.executeUpdate(stringBuffer.toString());
            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.getInstance().closeResource(state);
            JDBCUtil.getInstance().closeResource(conn);
        }
        return 0;
    }

    @Override
    //按学号删除
    public int deleteStu(String sno) {
        Connection conn = JDBCUtil.getInstance().getConnection();
        Statement state = null;
        try {
            state = conn.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("delete from student where sno = '");
            stringBuffer.append(sno);
            stringBuffer.append("'");
            //返回受影响的行数
            int affectedRows = state.executeUpdate(stringBuffer.toString());
            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.getInstance().closeResource(state);
            JDBCUtil.getInstance().closeResource(conn);
        }
        return 0;
    }
}
