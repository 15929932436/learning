package com.example.ba03;

import com.example.ba02.Student;

// 目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        // 给doSome方法增加一个功能，在doSome()执行之前，输出方法的执行时间
        System.out.println("===目标方法doSome()===");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("===目标方法doOther()===");
        return "abcd";
    }

    @Override
    public Student doOther2() {
        Student res = new Student();
        res.setAge(12);
        res.setName("hello");
        return res;
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("====业务方法doFirst()====");
        return "doFirst";
    }
}
