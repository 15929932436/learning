package com.example;

import com.example.dao.StudentDao;
import com.example.domain.Student;
import com.example.service.StudentService;
import com.sun.xml.internal.ws.addressing.WsaTubeHelper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        String names[] = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("容器中对象的名称：" + name + "|" + ctx.getBean(name).getClass().getName());
        }
    }

    @Test
    public void testDaoInsert() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        // 获取spring容器中的dao对象
        StudentDao dao = (StudentDao) ctx.getBean("studentDao");
        Student student = new Student();
        student.setId(1013);
        student.setName("周峰");
        student.setEmail("zhoufeng@qq.com");
        student.setAge(20);

        int nums = dao.insertStudent(student);
        System.out.println("nums = " + nums);
    }

    @Test
    public void testServiceInsert() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        // 获取spring容器中的dao对象
        StudentService service = (StudentService) ctx.getBean("studentService");
        Student student = new Student();
        student.setId(1015);
        student.setName("李胜利");
        student.setEmail("lishengli@qq.com");
        student.setAge(26);

        int nums = service.addStudent(student);
        // spring和mybatis整合在一起使用时，事务是自动提交的。无需执行SqlSession.commit()；
        System.out.println("nums = " + nums);
    }

    @Test
    public void testServiceSelect() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        // 获取spring容器中的dao对象
        StudentService service = (StudentService) ctx.getBean("studentService");
        List<Student> students = service.queryStudents();
        for (Student stu : students) {
            System.out.println(stu);
        }
    }
}
