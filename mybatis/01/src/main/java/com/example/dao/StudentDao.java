package com.example.dao;

import com.example.domain.Student;

import java.util.List;

/**
 * 接口操作student表
 */
public interface StudentDao {
    /**
     * 查询student表中的所有数据
     */
    public List<Student> selectStudents();

    /**
     * 插入方法
     *
     * @param student， 表示要插入到数据库的数据
     * @return int, 表示执行insert操作后影响数据库的行数
     */
    public int insertStudent(Student student);
}
