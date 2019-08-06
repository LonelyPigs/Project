package com.train.day19.work.transaction;

import com.train.day19.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 选课
 * course：课程信息表
 * totalcount：课程最大容纳人数表，当有人选择某门课程时，该课程总人数就减一
 * coursenumber：已选某课程的人数，
 */
public class TransactionTest {

    public static void main(String[] args) {
        saveStudentNumber();
    }

    public static void saveStudentNumber(){
        //获取连接
        Connection conn = JdbcUtil.getConnection();
        //
        PreparedStatement preparedStatement = null;

        try {
            //关闭自动提交功能
            conn.setAutoCommit(false);
            //完成coursenumber表添加事务
            //创建SQL语句
            String sqlInsert = "insert into coursenumber values(null,001,10)";
            preparedStatement = conn.prepareStatement(sqlInsert);
            preparedStatement.executeUpdate();

            //完成totalcount表人数修改事务
            String sqlUpdate = "update totalcount set total = total - 10 where cno = 001";
            preparedStatement = conn.prepareStatement(sqlUpdate);
            preparedStatement.executeUpdate();

            //手动提交修改，是SQL执行修改到数据库中
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            JdbcUtil.closeResource(preparedStatement);
            JdbcUtil.closeResource(conn);
        }


    }

}
