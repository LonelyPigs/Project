package com.daowork;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MysqlOperator extends  HeroOperator {

    public static void main(String[] args) {
         MysqlOperator mysql=new MysqlOperator();


        List<Hero> heroList = new ArrayList<>();
       //查询所有数据
       // heroList =mysql.findAllHero();
        //模糊查询
       // heroList =mysql.findByUserNameLike("zhao");
        //排序查询
        //heroList =mysql.findOrderByUserName("sname");
     //模糊查询 排序查询 分页
        heroList =mysql.findByUserNameLikeOrderLimit("zhao",1,2);
        Iterator<Hero> iterator=heroList.iterator();
        while(iterator.hasNext()){

            System.out.println(iterator.next());
        }
//        Hero hero =new Hero();
//        hero.setSage(19);
//        hero.setSno("200215113");hero.setSname("shishi");hero.setSsex("女");
        //插入一条数据
//        System.out.println( mysql.insertHero(hero));
//        hero.setId(23);
        //修改一条数据
//        System.out.println( mysql.updateHeroById(hero));
//       删除数据通过id
//        System.out.println(mysql.deleteHeroById(23));

    }





}
