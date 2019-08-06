package com.train.day19.work.query;

import com.train.day18.JDBCUtil;

import java.sql.*;

public class JDBCTest {

    public static void main(String[] args) {
        queryByStudentNameLike("s%");
        System.out.println("----------------------------");
        queryOrderByField("Sage");
        System.out.println("----------------------------");
        queryByFieldLikeOrderLimit("%",2,2);

    }

    /**
     * 按名称字段模糊查找
     * @param userName：名称字段
     */
    public static void queryByStudentNameLike(String userName){
        //获取连接
        Connection conn = JDBCUtil.getInstance().getConnection();

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            String sql = "select * from student where sname like ?";
            // 预先对SQL语句执行语法的校验， ? 对应的内容，后面不管传递什么进来，都当作是字符串处理
            preparedStatement = conn.prepareStatement(sql);
            //为占位符依次设置值，索引从1开始
            preparedStatement.setString(1, userName);
            //执行查询
            rs = preparedStatement.executeQuery();
            //遍历结果集
            while (rs.next()){
                String sno = rs.getString(1);
                String sname = rs.getString(2);
                String ssex = rs.getString(3);
                int sage = rs.getInt(4);
                String sdepart = rs.getString(5);
                System.out.println(sno + " , " + sname + " , " + ssex + " , " + sage + " , " + sdepart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            JDBCUtil.getInstance().closeResource(rs);
            JDBCUtil.getInstance().closeResource(preparedStatement);
            JDBCUtil.getInstance().closeResource(conn);
        }
    }

    /**
     * 根据某个字段进行排序（降序）的操作
     * @param fieldName：字段的名称
     */
    public static void queryOrderByField(String fieldName){
        //获取连接
        Connection conn = JDBCUtil.getInstance().getConnection();
        //
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM student ORDER BY ? DESC";
            // 预先对SQL语句执行语法的校验， ? 对应的内容，后面不管传递什么进来，都当作是字符串处理
            preparedStatement = conn.prepareStatement(sql);
            //为占位符依次设置值，索引从1开始
            preparedStatement.setString(1, fieldName);
            //执行查询
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                String sno = rs.getString(1);
                String sname = rs.getString(2);
                String ssex = rs.getString(3);
                int sage = rs.getInt(4);
                String sdepart = rs.getString(5);
                System.out.println(sno + " , " + sname + " , " + ssex + " , " + sage + " , " + sdepart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.getInstance().closeResource(rs);
            JDBCUtil.getInstance().closeResource(preparedStatement);
            JDBCUtil.getInstance().closeResource(conn);
        }
    }

    /**
     * 完成根据姓名字段模糊查找并排序（升序），然后分页获取第二页数据的操作（每页显示2条）
     * @param fieldName
     * @param currPage：当前页数:2
     * @param pageSize：每页显示的条数:2
     */
    public static void queryByFieldLikeOrderLimit(String fieldName,int currPage, int pageSize){
        //获取连接
        Connection conn = JDBCUtil.getInstance().getConnection();

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            String sql = "select * from student where sname like ? ORDER BY sname ASC limit ?,? ";
            // 预先对SQL语句执行语法的校验， ? 对应的内容，后面不管传递什么进来，都当作是字符串处理
            preparedStatement = conn.prepareStatement(sql);
            //为占位符依次设置值，索引从1开始
            preparedStatement.setString(1, fieldName);
            //用于指定查询记录的起始位置
            preparedStatement.setInt(2,(currPage - 1) * pageSize);
            //用于指定查询数据所返回的记录数
            preparedStatement.setInt(3,pageSize);
            //执行查询
            rs = preparedStatement.executeQuery();
            //遍历结果集
            while (rs.next()){
                String sno = rs.getString(1);
                String sname = rs.getString(2);
                String ssex = rs.getString(3);
                int sage = rs.getInt(4);
                String sdepart = rs.getString(5);
                System.out.println(sno + " , " + sname + " , " + ssex + " , " + sage + " , " + sdepart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            JDBCUtil.getInstance().closeResource(rs);
            JDBCUtil.getInstance().closeResource(preparedStatement);
            JDBCUtil.getInstance().closeResource(conn);
        }
    }

}
