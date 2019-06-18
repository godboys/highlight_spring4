package com.wisely.highlight_springmvc4.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 简单控制器
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-14 16:33
 **/
@Controller  // 1.利用@Controller注解声明是一个控制器
public class HelloController {

    @RequestMapping("/login")  // 2.利用@RequestMapping配置URL和方法之间的映射。
    public String helloword(){
        System.out.println("helloworld");
        // 3.通过上面ViewResolver的Bean配置，返回值为index，
        // 说明我们的页面放置的路径为/WEB-INF/classes/views/index.jsp
        return "/index";
    }

    /*@RequestMapping("/index")  // 2.利用@RequestMapping配置URL和方法之间的映射。
    @ResponseBody
    public String index(){
        // 3.通过上面ViewResolver的Bean配置，返回值为index，
        // 说明我们的页面放置的路径为/WEB-INF/classes/views/index.jsp
        return "helloworld";
    }*/
}