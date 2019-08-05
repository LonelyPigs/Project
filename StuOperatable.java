package com.train.day18;

import java.util.List;

public interface StuOperatable {
    /**
     * 查询所有数据
     * @return  将所有数据封装到集合中返回
     */
    List<Student> findAllStu();

    /**
     * 添加数据
     * @param student
     * @return  执行sql 后，返回受影响的行数
     */
    int insertStu(Student student);

    /**
     * 修改信息
     * @param student：待修改的对象
     * @return  执行sql 后，返回受影响的行数
     */
    int updateStu(Student student);

    /**
     * 根据学号删除
     * @param sno
     * @return 执行sql 后，返回受影响的行数
     */
    int deleteStu(String sno);


}
