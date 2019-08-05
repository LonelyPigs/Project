package jdbc;

import java.util.List;

public interface StudentOperatable {
    /**
     * @return 将所有数据封装到集合中返回
     */
    List<Student> findAllStudent();

    /**
     * @param 待修改的对象
     * @return 受影响的行数
     */
    int updateStudentById(Student student);

    int insertStudent(Student student);

    int deleteStudentById(String sno);
}
