package com.daowork;

import java.util.List;

public interface HeroOperatable {
    /**
     * 查询所有数据
     * @return  将所有数据封装到集合中返回
     */
    List<Hero>  findAllHero();
    /**
     * 模糊查询
     * @return  将所有数据封装到集合中返回
     */
    List<Hero>  findByUserNameLike(String userName);
    /**
     * 按照某个字段进行降序
     * @param   userName
     * @return 将所有数据封装到集合中返回
     */
    List<Hero>  findOrderByUserName(String userName);

    /**
     * 添加数据
     * @param userName, currPage, pageSize
     *       userName   用户名
     *       currPage   当前页
     *       pageSize   每页显示的数量
     * @return 将所有数据封装到集合中返回
     */

   List<Hero> findByUserNameLikeOrderLimit(String userName, int currPage,int pageSize);
    /**
     * 修改数据
     * @param hero
     * @return 执行sql后，返回受影响的行数
     */
    int updateHeroById(Hero hero);

    /**
     * 添加数据
     * @param hero
     * @return 执行sql后，返回受影响的行数
     */
    int insertHero(Hero hero);

    /**
     * 根据id删除
     * @param id
     * @return 执行sql后，返回受影响的行数
     */
    int deleteHeroById(int id);



}
