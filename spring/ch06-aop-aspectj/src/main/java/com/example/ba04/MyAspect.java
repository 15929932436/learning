package com.example.ba04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Date;

/**
 * @Aspect : 是aspectj框架中的注解。
 *     作用 ：表示当前类是切面类。
 *     切面类：是用来给业务方法增加功能的类，在这个类中游切面的功能代码
 *     位置：在类定义的上面
 */
@Aspect
public class MyAspect {
    @After(value = "mypt()")
    public void myAfter() {
        System.out.println("执行最终通知，总是会被执行的代码");
    }

    @Before(value = "mypt()")
    public void myBefore() {
        System.out.println("前置通知，在目标方法执行之前执行的");
    }

    /**
     * @Pointcut：定义和管理切入点，如果你的项目中有多个切入点表达式是重复的，可以服用的。
     *            可以使用@Pointcut
     *       属性：value 切入点表达式
     *       位置：在自定义的方法上面
     *  特点：
     *     当使用@Pointcut定义在一个方法的上， 此时这个方法的名称就是切入点表达式的别名。
     *     其他的通知中，value属性就可以使用这个方法名称，代替切入点表达式了
     */
    @Pointcut(value = "execution(* *..SomeServiceImpl.doThird(..))")
    private void mypt() {
        // 无需代码
    }
}
