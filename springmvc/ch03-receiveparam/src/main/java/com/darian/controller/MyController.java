package com.darian.controller;

import com.darian.controller.com.darian.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @RequestMapping:
 *     value : 所有请求地址的公共部分，叫做模块名称
 *     位置： 放在类的上面
 */
@Controller
public class MyController {

    /**
     * 逐个接收请求参数：
     *      要求：处理器（控制器）方法的形参名和请求中参数名必须一致。
     *           同名的请求参数赋值给同名的形参
     *
     * 框架接收请求参数
     *     1. 使用request对象接收请求参数
     *        String strName = request.getParameter("name");
     *        String strAge = request.getParameter("age");
     *     2. springmvc框架同归DispatcherServlet调用MyController的doSome()方法
     *        调用方法是，按名称对应，把接收的参数赋值给形参
     *        doSome(strName, Integer.valueOf(strAge))
     *        框架会提供类型转换的功能，能把String转为int, long, float, double等类型
     *
     * 400状态码是客户端错误，表示提交请求参数过程中，发生了问题
     *
     */
    @RequestMapping(value = "receiveproperty.do")
    public ModelAndView doSome(String name, Integer age) {
        // 可以在方法中直接使用name, age
        // 处理some.do的请求了。 相当于service调用处理完成了。
        ModelAndView mv = new ModelAndView();

        // 添加数据，框架在请求的最后把数据放入到request作用域。
        // request.setAttribute("msg", "欢迎使用springmvc做web开发");
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("show");
        return mv;
    }

    /**
     * 请求中参数名和处理器方法的形参名不一样
     * @RequestParam：逐个接收请求参数中，解决请求中参数名形参名不一样的问题
     *           属性：1. value 请求中的参数名称
     *                2. required 是一个boolean，默认是true
     *                   true：表示请求中必须包含次参数
     *           位置：在处理器方法的形参定义的前面
     */
    @RequestMapping(value = "receiveparam.do")
    public ModelAndView receiveParam(@RequestParam(value = "rname", required = false) String name,
                                     @RequestParam(value = "rage", required = false) Integer age) {
        // 可以在方法中直接使用name, age
        // 处理some.do的请求了。 相当于service调用处理完成了。
        ModelAndView mv = new ModelAndView();

        // 添加数据，框架在请求的最后把数据放入到request作用域。
        // request.setAttribute("msg", "欢迎使用springmvc做web开发");
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("show");
        return mv;
    }

    /**
     * 处理器方法形参是java对象，这个对象的属性名和请求中参数名是一样的
     * 框架会创建形参的java对象，给属性赋值。请求中的参数值是name，框架会调用setName()
     * @return
     */
    @RequestMapping(value = "receiveobject.do")
    public ModelAndView receiveParam(Student myStudent) {
        System.out.println("receiveParam, name =" + myStudent.getName() + "   age = " + myStudent.getAge());
        // 可以在方法中直接使用name, age
        // 处理some.do的请求了。 相当于service调用处理完成了。
        ModelAndView mv = new ModelAndView();

        // 添加数据，框架在请求的最后把数据放入到request作用域。
        // request.setAttribute("msg", "欢迎使用springmvc做web开发");
        mv.addObject("myname", myStudent.getName());
        mv.addObject("myage", myStudent.getAge());
        mv.addObject("mystudent", myStudent);
        mv.setViewName("show");
        return mv;
    }
}
