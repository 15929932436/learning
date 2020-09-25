package com.darian.controller;

import com.darian.controller.com.darian.vo.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name, Integer age) {
        System.out.println("doRetrunView, name=" + name + "   age=" + age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("show");

        return mv;
    }

}
