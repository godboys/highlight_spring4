package com.wisely.highlight_springmvc4.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 拦截器
 * </p>
 *
 * @Author yangjian
 * @Create 2019-6-21 10:58
 **/
// 1.继承HandlerInterceptorAdapter类来实现自定义拦截器
public class DemoInterceptor extends HandlerInterceptorAdapter {

    // 2.重写preHandle方法，在请求发生前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    // 3.重写postHandle方法，在请求完成后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("本次请求处理时间为:" + new Long(endTime - startTime)+"ms");
        request.setAttribute("handlingTime", endTime - startTime);
    }

}