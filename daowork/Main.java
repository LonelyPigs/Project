package com.daowork;

import com.daowork.JdbcUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        try {
            saveOrder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 产生一个订单，订单中有商品的数量，根据商品的数量，将库存中的商品数据相应减少
     */
    public static void saveOrder() throws IOException {

        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            // 默认情况下，自动提交是开启的，1-DDL,DCL 2-程序运行结束
            // 关闭自动提交功能，设置为false，
            // 需要手动调用commit来提交，将修改持久化到数据库
         connection.setAutoCommit(false);

            String sql = "insert into gorder values(null, 4, 10)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            // 回滚，使rollback所在事务之前的所有sql执行失效
      //  connection.rollback();
//
     //   int i = 10 / 0;

            String sql1 = "update sto set gcout = gcout-10 where gid=4";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();

            // 提交修改，是sql执行修改到数据中
     connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeResource(preparedStatement);
            JdbcUtil.closeResource(connection);
        }


    }

}

