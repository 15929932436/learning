package org.example;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudentsIf() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("李四");
        student.setAge(18);
        List<Student> students = dao.selectStudentIf(student);
        for (Student stu : students) {
            System.out.println("if ====" + stu);
        }

    }

    @Test
    public void testSelectStudentsWhere() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        //student.setName("李四");
        student.setAge(18);
        List<Student> students = dao.selectStudentWhere(student);
        for (Student stu : students) {
            System.out.println("if ====" + stu);
        }

    }

    @Test
    public void testFor() {
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);

        // String sql = "select * from student where id in (1001, 1002, 1003)";
        String sql = "select * from student where id in";
        StringBuilder builder = new StringBuilder();

        // 添加开始的(
        builder.append("(");
        for (Integer i : list) {
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        // 循环结尾
        builder.append(")");
        sql += builder.toString();
        System.out.println("sql == " + sql);
    }

    @Test
    public void testSelectStudentsForEach() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students = dao.selectForeachOne(list);
        for (Student stu : students) {
            System.out.println("foreach--one ====" + stu);
        }

    }

    @Test
    public void testSelectForTwo() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> stuList = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1002);
        stuList.add(s1);

        s1 = new Student();
        s1.setId(1005);
        stuList.add(s1);

        List<Student> students = dao.selectForeachTwo(stuList);
        for (Student stu : students) {
            System.out.println("foreach--one ====" + stu);
        }

    }

    @Test
    public void testSelectAllPageHelper() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        // 加入PageHelper的方法，分页
        // pageNum:第几页，从1开始
        // PageSize: 一页中游多少行数据
        PageHelper.startPage(1, 3);
        List<Student> students = dao.selectAll();
        for (Student stu : students) {
            System.out.println("foreach--one ====" + stu);
        }

    }

}
