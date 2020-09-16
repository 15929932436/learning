package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MybatisUtils;
import org.example.vo.QueryParam;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMyBatis {

    @Test
    public void testSelectStudentsById() {
        /**
         * 使用mybatis的动态代理机制，使用sqlSession.getMapper(dao接口)
         * getMapper能获取dao接口对于的实现类对象
         */
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = dao.selectStudentById(1002);

        System.out.println("student = " + student);

    }

    @Test
    public void testSelectMultiParam() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectMultiParam("李四", 20);

        for (Student stu : students) {
            System.out.println("学生 = " + stu);
        }

        sqlSession.close();
    }

    @Test
    public void testSelectCount() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        int counts = dao.countStudent();
        System.out.println("学生的数量=" + counts);
        sqlSession.close();
    }

    // 返回Map
    @Test
    public void testSelectMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Map<Object, Object> map = dao.selectMapById(1001);
        System.out.println("map = " + map);

        sqlSession.close();
    }

    @Test
    public void testSelectAllStudents() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectAllStudent();

        for (Student stu : students) {
            System.out.println("学生 = " + stu);
        }

        sqlSession.close();
    }

    @Test
    public void testSelectLikeOne() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        String name = "%李%";
        List<Student> students = dao.selectLikeOne(name);

        for (Student stu : students) {
            System.out.println("学生 = " + stu);
        }

        sqlSession.close();
    }

    @Test
    public void testSelectLikeTwo() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        String name = "李";
        List<Student> students = dao.selectLikeTwo(name);

        for (Student stu : students) {
            System.out.println("学生 = " + stu);
        }

        sqlSession.close();
    }
}
