package com.wisely.highlight_springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 定制ControllerAdvice
 * </p>
 * @Author yangjian
 * @Create 2019-6-21 11:12
 **/

/**
 * @ControllerAdvice声明一个控制器建言，
 * @ControllerAdvice组合了@Component注解，所以自动注册为
 * Spring的Bean。
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * 2. @ExceptionHandler在此处定义全局处理，通过@ExceptionHandler的value属性可过滤拦截的条件，在此处我们可以看出我们拦截所有的Exception。
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class) //2
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");// error
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    /**
     * 3. 此处使用@ModelAttribute注解将键值对添加到全局，所
     * 有注解的@RequestMapping的方法可获得此键值对。
     * @param model
     */
    @ModelAttribute //3
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息"); //3
    }
    @InitBinder //4 通过@InitBinder注解定制WebDataBinder。
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id"); //5. 此处演示忽略request参数的id
    }



}


