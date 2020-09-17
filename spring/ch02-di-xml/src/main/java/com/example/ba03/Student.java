package com.example.ba03;

public class Student {
    private String name;
    private int age;

    // 声明一个应用类型
    private School school;

    /**
     * 创建有参数的构造放啊
     *
     * @param myName nama
     * @param myAge age
     * @param mySchool school
     */
    public Student(String myName, int myAge, School mySchool) {
        System.out.println("=====Student有参数构造方法======");
        // 属性赋值
        this.name = myName;
        this.age = myAge;
        this.school = mySchool;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
