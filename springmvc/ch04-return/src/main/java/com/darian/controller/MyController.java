package com.darian.controller;

import com.darian.controller.com.darian.vo.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @RequestMapping:
 *     value : 所有请求地址的公共部分，叫做模块名称
 *     位置： 放在类的上面
 */
@Controller
public class MyController {

    /**
     * 处理器方法返回string---表示逻辑视图名称，需要配置视图解析器
     */
    @RequestMapping(value = "returnString-view.do")
    public String doReturnView(HttpServletRequest request, String name, Integer age) {
        System.out.println("doRetrunView, name=" + name + "   age=" + age);

        // 可以自己手工添加数据到request作用于
        request.setAttribute("myname", name);
        request.setAttribute("myage", age);


        // show: 逻辑视图名称，项目中配置了视图解析器
        // 框架对视图执行forward转发操作
        return "show";
    }

    // 处理器方法返回string, 表示完整视图路径， 此时不能配置视图解析器
    @RequestMapping(value = "returnString-view2.do")
    public String doReturnView2(HttpServletRequest request, String name, Integer age) {
        System.out.println("doRetrunView, name=" + name + "   age=" + age);

        // 可以自己手工添加数据到request作用于
        request.setAttribute("myname", name);
        request.setAttribute("myage", age);


        // 完整视图路径，项目中不能配置视图解析器
        // 框架对视图执行forward转发操作
        return "/WEB-INF/view/show.jsp";
    }

    // 处理器方法返回void，响应ajax请求
    // 手工实现ajax, jsonshuju :代码上有重复的 1. java对象转为json; 2. 通过HttpServletResponse输出json数据
    @RequestMapping(value = "returnVoid-ajax.do")
    public void doReturnVoidAjax(HttpServletResponse response, String name, Integer age) throws IOException {
        System.out.println("doReturnVoidAjax, name=" + name + "   age=" + age);
        // 处理ajax, 使用json做数据的格式
        // service调用完成了，使用Student表示处理结果
        Student student = new Student();
        student.setName(name);
        student.setAge(age);

        String json = "";
        // 把结果的对象转为json格式的数据
        if (student != null) {
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(student);
            System.out.println("student转换的json===" + json);
        }

        // 输出数据，响应ajax的请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }

    /**
     * 处理器方法返回一个Student，通过框架转为json，响应ajax请求
     * @ResponseBody
     *    作用：把处理器方法返回对象转为json后，通过HttpServletResponse输出给浏览器
     *    位置：方法的定义上面，和其他注解没有顺序关系
     *
     * 返回对象框架的处理流程：
     *   1. 框架会把返回Student类型，调用框架中的ArrayList<HttpMessageConverter>中每个类的canWrite()方法
     *      来检查哪个HttpMessageConverter接口的实现类能处理Student类型的数据。---MappingJackson2HttpMessageConverter
     *
     *   2. 框架会调用实现类的write()， MappingJackson2HttpMessageConverter的write()方法
     *      把李四同学的student对象转为json，调用jackson的ObjectMapper实现转为json
     *      contentType: application/json;charset=utf-8
     *
     *   3. 框架会调用ResponseBody把2的结果数据输出到浏览器， ajax请求处理完成。

     */
    @ResponseBody
    @RequestMapping(value = "returnStudentJson.do")
    public Student doStudentJsonObject(String name, Integer age) {
        // 调用service， 获取请求结果数据, Student对象表示结果数据
        Student student = new Student();
        student.setName("李四同学");
        student.setAge(20);

        return student; // 会被框架转为json
    }

    /**
     * 处理器方法返回List<Student>
     */
    @ResponseBody
    @RequestMapping(value = "returnStudentJsonArray.do")
    public List<Student> doStudentJsonObjectArray(String name, Integer age) {
        List<Student> list = new ArrayList<>();
        // 调用service， 获取请求结果数据, Student对象表示结果数据
        Student student = new Student();
        student.setName("李四同学");
        student.setAge(20);
        list.add(student);

        student = new Student();
        student.setName("张三");
        student.setAge(28);
        list.add(student);

        return list;
    }

    /**
     * 处理器方法返回的是String， String表示数据的，不是视图。
     * 区分返回值String是数据，还是视图，看有没有@ResponseBody注解
     * 如果有@ResponseBody注解，返回String就是数据，反之就是视图
     *
     * 默认使用"text/plain;charset=ISO-8859-1"作为contentType, 导致中文有乱码，
     * 解决方案：给RequestMapping增加一个属性 produces, 使用这个属性指定新的contentType.
     */
    @ResponseBody
    @RequestMapping(value = "/returnStringData.do", produces = "text/plain;charset=utf-8")
    public String doStringData(String name, Integer age) {
        return "Hello SpringMVC 返回对象，表示数据";
    }

}
