package com.wisely.highlight_springmvc4;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


/**
 * <p>
 * Web配置
 * WebApplicationInitializer是Spring提供用来配置Servlet3.0+配置的接口，
 * 从而实现了替代web.xml的位置。实现此接口将会自动被SpringServletContainerInitializer
 * （用来启动Servlet 3.0容器）获取到。
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-14 16:23
 **/
public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyMvcConfig.class);
        //新建WebApplicationContext，注册配置类，并将其和当前servletContext关联。
        ctx.setServletContext(servletContext);
        ctx.refresh(); // 3.刷新容器
        //注册Spring MVC的DispatcherServlet。
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        servlet.setAsyncSupported(true);//1 此句开启异步方法支持  Servlet 3.0+异步方法处理
    }
}