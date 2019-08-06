package com.daowork;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HeroOperator implements HeroOperatable{
    @Override
    public List<Hero> findAllHero() {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;
        ResultSet rs = null;
        List<Hero> heroList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String sql = "select * from hero";
            rs = statement.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt(1);
                String sno = rs.getString(2);
                String sname = rs.getString("sname");
                String ssex = rs.getString("ssex");
                int sage = rs.getInt(6);
                Hero hero = new Hero();
                hero.setId(id);
                hero.setSname(sname);
                hero.setSsex(ssex);
                hero.setSno(sno);
                hero.setSage(sage);
                heroList.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return heroList;
    }

    @Override
    public List<Hero> findByUserNameLike(String userName) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;
        ResultSet rs = null;
        List<Hero> heroList = new ArrayList<>();
        try {
            statement = connection.createStatement();



            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("select * from hero where sname like");
            stringBuffer.append("'");
            stringBuffer.append(userName);
            stringBuffer.append("%");
            stringBuffer.append("'");
            System.out.println(stringBuffer.toString());
            rs = statement.executeQuery(stringBuffer.toString());



            while (rs.next()){
                int id = rs.getInt(1);
                String sno = rs.getString(2);
                String sname = rs.getString("sname");
                String ssex = rs.getString("ssex");
                int sage = rs.getInt(6);
                Hero hero = new Hero();
                hero.setId(id);
                hero.setSname(sname);
                hero.setSsex(ssex);
                hero.setSno(sno);
                hero.setSage(sage);
                heroList.add(hero);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return heroList;
    }

    @Override
    public List<Hero> findOrderByUserName(String userName) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;
        ResultSet rs = null;
        List<Hero> heroList = new ArrayList<>();
        try {
            statement = connection.createStatement();

//select * from hero order by sname DESC;

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("select * from hero order by ");

            stringBuffer.append(userName);
            stringBuffer.append(" desc");

            System.out.println(stringBuffer.toString());
            rs = statement.executeQuery(stringBuffer.toString());



            while (rs.next()){
                int id = rs.getInt(1);
                String sno = rs.getString(2);
                String sname = rs.getString("sname");
                String ssex = rs.getString("ssex");
                int sage = rs.getInt(6);
                Hero hero = new Hero();
                hero.setId(id);
                hero.setSname(sname);
                hero.setSsex(ssex);
                hero.setSno(sno);
                hero.setSage(sage);
                heroList.add(hero);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return heroList;
    }

    @Override
    public List<Hero> findByUserNameLikeOrderLimit(String userName, int currPage, int pageSize) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;
        ResultSet rs = null;
        List<Hero> heroList = new ArrayList<>();
        try {
            statement = connection.createStatement();


  //select * from hero where sname like 'zhao%' order by sno DESC;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("select * from hero where sname like");
            stringBuffer.append("'");
            stringBuffer.append(userName);
            stringBuffer.append("%");
            stringBuffer.append("'");
            stringBuffer.append(" order by sno desc");


            System.out.println(stringBuffer.toString());
            rs = statement.executeQuery(stringBuffer.toString());

          int begin =currPage*pageSize;
          int len=begin+pageSize-1;
          int move=0;
            while (rs.next()){
                if(move>=begin&&move<=len) {
                    int id = rs.getInt(1);
                    String sno = rs.getString(2);
                    String sname = rs.getString("sname");
                    String ssex = rs.getString("ssex");
                    int sage = rs.getInt(6);
                    Hero hero = new Hero();
                    hero.setId(id);
                    hero.setSname(sname);
                    hero.setSsex(ssex);
                    hero.setSno(sno);
                    hero.setSage(sage);
                    heroList.add(hero);
                }
                move++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return heroList;
    }

    @Override
    public int updateHeroById(Hero hero) {

        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();

            stringBuffer.append("update hero set SNO = '");
            stringBuffer.append(hero.getSno());
            stringBuffer.append("', SNAME = '");
            stringBuffer.append(hero.getSname());
            stringBuffer.append("', SSEX = '");
            stringBuffer.append(hero.getSsex());
            stringBuffer.append("', SAGE = ");
            stringBuffer.append(hero.getSage());
            stringBuffer.append(" where id = ");
            stringBuffer.append(hero.getId());




            System.out.println(stringBuffer.toString());

            int affectedRows = statement.executeUpdate(stringBuffer.toString());
            return  affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }


  return 0;
    }

    @Override
    public int insertHero(Hero hero) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("update hero set SNO = '");
            stringBuffer.append(hero.getSno());
            stringBuffer.append("', SNAME = '");
            stringBuffer.append(hero.getSname());
            stringBuffer.append("', SSEX = '");
            stringBuffer.append(hero.getSsex());
            stringBuffer.append("', SAGE = ");
            stringBuffer.append(hero.getSage());
            stringBuffer.append(" where id = ");
            stringBuffer.append(hero.getId());


            System.out.println(stringBuffer.toString());

            int affectedRows = statement.executeUpdate(stringBuffer.toString());


            return  affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }


        return 0;
    }

    @Override
    public int deleteHeroById(int id) {


        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("delete from hero where id=");

            stringBuffer.append(id);


            System.out.println(stringBuffer.toString());

            int affectedRows = statement.executeUpdate(stringBuffer.toString());

            return  affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }


        return 0;
    }
}
