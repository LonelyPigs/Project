package homework.h9.jdbc;

import jdbc.Student;

import java.util.List;

public interface StudentOperatable {
    /**
     * 根据学号字段模糊查找
     *
     * @param sno
     * @return 将所有数据封装到集合中返回
     */
    List<Student> findByIdLike(String sno);

    /**
     * 根据指定字段降序排序
     *
     * @param sno
     * @return
     */
    List<Student> findOrderByField(String field);

    /**
     * 根据学号字段升序排序，并指定分页每页的条数，分页获取指定页数的查询结果
     *
     * @param userName
     * @param currPage
     * @param pageSize
     * @return
     */
    List<Student> findByIdLikeOrderLimit(String sno, int currPage, int pageSize);

}
