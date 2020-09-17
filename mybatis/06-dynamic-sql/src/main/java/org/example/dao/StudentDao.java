package org.example.dao;

import org.example.domain.Student;

import java.util.List;

public interface StudentDao {

    // 动态sql，使用java对象做为参数
    List<Student> selectStudentIf(Student student);

    // where使用
    List<Student> selectStudentWhere(Student student);

    // foreach 用法1
    List<Student> selectForeachOne(List<Integer> idList);

    // foreach 用法2
    List<Student> selectForeachTwo(List<Student> stuList);

    // 使用PageHelper分页数据
    List<Student> selectAll();
}
