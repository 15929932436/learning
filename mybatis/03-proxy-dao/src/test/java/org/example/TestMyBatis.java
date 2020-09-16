package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudents() {
        /**
         * 使用mybatis的动态代理机制，使用sqlSession.getMapper(dao接口)
         * getMapper能获取dao接口对于的实现类对象
         */
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        System.out.println("dao = " + dao.getClass().getName()); // com.sun.proxy.$Proxy2  jdk的动态代理
        // 调用dao的方法，执行数据库的操作
        List<Student> students = dao.selectStudents();
        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }

    }

    @Test
    public void testInsertStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1007);
        student.setName("李飞");
        student.setEmail("lifei@qq.com");
        student.setAge(24);
        int nums = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println("添加对象的数量：" + nums);
    }
}
