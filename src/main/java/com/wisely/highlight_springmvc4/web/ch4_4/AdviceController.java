package com.wisely.highlight_springmvc4.web.ch4_4;

import com.wisely.highlight_springmvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 演示控制器
 * </p>
 *
 * @Author yangjian
 * @Create 2019-6-21 13:46
 **/
@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj){//1
        throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute:"+ msg);
    }

}