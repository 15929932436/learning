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

    /**
     * 多个参数，使用java对象作为接口中方法的参数
     *
     * @param param 参数
     * @return students
     */
    List<Student> selectMultiObject(QueryParam param);


    List<Student> selectMultiStudent(Student student);

    /**
     * 多个参数，简单类型的，按位置传值
     * mybatis 3.4之前，使用#{0}, #{1}
     * mybatis 3.4之后，使用#{arg0}, #{arg1}
     *
     * @param name name
     * @param age age
     * @return students
     */
    List<Student> selectMultiPosition(String name, Integer age);


    /**
     * 使用map
     *
     * @param data data
     * @return students
     */
    List<Student> selectMultiByMap(Map<String, Object> data);

    List<Student> selectUse$(@Param("myname") String name);

    List<Student> selectUse$Order(@Param("colName") String colName);
}
