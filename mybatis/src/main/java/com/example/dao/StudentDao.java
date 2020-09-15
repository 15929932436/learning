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
}
