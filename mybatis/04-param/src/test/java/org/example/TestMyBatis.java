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
    public void testSelectMultiObject() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        QueryParam param = new QueryParam();
        param.setParamName("张三");
        param.setParamAge(28);

        List<Student> students = dao.selectMultiObject(param);

        for (Student stu : students) {
            System.out.println("学生 = " + stu);
        }

        sqlSession.close();
    }

    @Test
    public void testSelectMultiStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setAge(28);
        student.setName("张三");

        List<Student> students = dao.selectMultiStudent(student);

        for (Student stu : students) {
            System.out.println("学生 = " + stu);
        }

        sqlSession.close();
    }

    @Test
    public void testSelectMultiPosition() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectMultiPosition("李四", 20);

        for (Student stu : students) {
            System.out.println("学生 = " + stu);
        }

        sqlSession.close();
    }


    @Test
    public void testSelectMultiMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Map<String, Object> data = new HashMap<>();
        data.put("myname", "张三");
        data.put("age", 28);
        List<Student> students = dao.selectMultiByMap(data);

        for (Student stu : students) {
            System.out.println("学生 = " + stu);
        }

        sqlSession.close();
    }

    @Test
    public void testSelectUse$() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectUse$("'李四'");

        for (Student stu : students) {
            System.out.println("学生 = " + stu);
        }

        sqlSession.close();
    }

    @Test
    public void testSelectUse$Order() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectUse$Order("name");

        for (Student stu : students) {
            System.out.println("学生 = " + stu);
        }

        sqlSession.close();
    }
}
