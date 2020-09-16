package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.domain.Student;
import org.example.vo.QueryParam;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    /**
     * 一个简单类型的参数：
     *    简单类型： mybatis把java的基本数据类型和String都叫简单类型
     *
     *    在mapper文件获取简单类型的一个参数的值，使用 #{任意字符}
     *
     * @param id id
     * @return student
     */
    Student selectStudentById(Integer id);

    /**
     * 多个参数：命名参数，在形参定义的前面加入 @Param("自定义参数名称");
     *
     * @param name name
     * @param age name
     * @return students
     */
    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage") Integer age);

    int countStudent();

    // 定义方法返回Map
    Map<Object, Object> selectMapById(Integer id);

    /**
     * 使用resultMap定义映射关系
     */
    List<Student> selectAllStudent();

    /**
     * 第一种模糊查询，在java代码中指定like的内容
     */
    List<Student> selectLikeOne(String name);

    /**
     * name就是李值，在mapper中拼接like "%" 李 "%"
     *
     * @param name name
     * @return students
     */
    List<Student> selectLikeTwo(String name);
}
