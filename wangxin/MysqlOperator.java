package com.daowork;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MysqlOperator extends  HeroOperator {

    public static void main(String[] args) {
         MysqlOperator mysql=new MysqlOperator();


        List<Hero> heroList = new ArrayList<>();

        heroList =mysql.findAllHero();
        Iterator<Hero> iterator=heroList.iterator();
        while(iterator.hasNext()){

            System.out.println(iterator.next());
        }
        Hero hero =new Hero();
        hero.setSage(18);
        hero.setSno("200215128");hero.setSname("wangxin");hero.setSsex("男");
        mysql.insertHero(hero);
        mysql.updateHeroById(hero);
        mysql.deleteHeroById(1);

    }





}
