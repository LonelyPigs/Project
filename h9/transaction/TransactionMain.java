package homework.h9.transaction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionMain {

    public static void main(String[] args) {
        try {
            saveOrder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 产生一个订单，对订单进行sql操作
     */
    public static void saveOrder() throws IOException {
        Connection connection = JdbcUtil.getInstance().getConnection();
        PreparedStatement ps = null;

        try {
            //关闭自动提交功能
            connection.setAutoCommit(false);

            String sql = "insert into gorder values(null,1,5)";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();

            //rollback，使之前的sql操作失效
            connection.rollback();

            String sql2 = "update sto set gcount = gcount - 5 where gid = 1";
            ps = connection.prepareStatement(sql2);
            ps.executeUpdate();

            //手动commit提交
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(ps);
            JdbcUtil.getInstance().closeResource(connection);
        }

    }

}
