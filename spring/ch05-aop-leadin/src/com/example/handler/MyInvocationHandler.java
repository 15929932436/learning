package com.example.handler;

import com.example.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    // 目标对象
    private Object target; // SomeServcieImple类

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 通过代理对象执行方法时，会调用执行这个invoke()
        System.out.println("执行MyIncationHandler中的invoke()");
        String methodName = method.getName();
        Object res = null;

        if ("doSome".equals(methodName)) {
            ServiceTools.doLog();
            // 执行目标类的方法，通过Method类实现
            res = method.invoke(target, args); // SomeServiceImpl.doSome
            ServiceTools.doTrans();
        } else {
            res = method.invoke(target, args); // SomeServiceImpl.doOther()
        }

        // 目标方法的执行结果
        return res;
    }
}
