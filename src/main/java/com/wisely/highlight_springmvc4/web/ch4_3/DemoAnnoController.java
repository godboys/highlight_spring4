package com.wisely.highlight_springmvc4.web.ch4_3;

import com.wisely.highlight_springmvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *
 * </p>
 *
 * @Author yangjian
 * @Create 2019-6-19 10:01
 **/
@Controller // 1 @Controller注解声明此类是一个控制器。
@RequestMapping("anno") // 2 @RequestMapping（“/anno”）映射此类的访问路径是/anno。
public class DemoAnnoController {

    /**
     * // 3 此方法未标注路径，因此使用类级别的路径/anno；
     * produces可定制返回的response的媒体类型和字符集，或需返回
     * 值是json对象，则设置produces=“application/json；
     * charset=UTF-8”，
     * @param request
     * @return
     */
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    // 4 演示可接受HttpServletRequest作为参数，当然也可以接受HttpServletReponse作为参数。此处的@ReponseBody用在返回值前面。
    public @ResponseBody String index(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access";
    }

    // 5 演示接受路径参数，并在方法参数前结合@PathVariable使用，访问路径为/anno/pathvar/xx。
    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access,str: " + str;
    }

    //6 演示常规的request参数获取，访问路径为/anno/requestParam？id=1。
    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access,id: " + id;
    }

    //7 演示解释参数到对象，访问路径为/anno/obj？id=1&name=xx。
    @RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
    //8 @ReponseBody也可以用在方法上。
    @ResponseBody
    public String passObj(DemoObj obj, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access, obj id: " + obj.getId()+" obj name:" + obj.getName();
    }

    //9 演示映射不同的路径到相同的方法，访问路径为/anno/name1或/anno/name2。
    @RequestMapping(value = { "/name1", "/name2" }, produces = "text/plain;UTF-8")
    public @ResponseBody String remove(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access";
    }


}