package com.example.ba03;

import com.example.ba02.Student;

public interface SomeService {
    void doSome(String name, Integer age);
    String doOther(String name, Integer age);

    Student doOther2();

    String doFirst(String name, Integer age);
}
