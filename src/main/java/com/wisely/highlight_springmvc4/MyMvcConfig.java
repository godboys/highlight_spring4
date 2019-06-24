package com.wisely.highlight_springmvc4;

import com.wisely.highlight_springmvc4.interceptor.DemoInterceptor;
import com.wisely.highlight_springmvc4.messageconverter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * <p>
 * Spring MVC配置
 * Spring MVC的ViewResolver
 * 这是Spring MVC视图（JSP下就是html）渲染的核心机制
 * SpringMVC里有一个接口叫做ViewResolver（我们的ViewResolver都实现该接口），实现这个接口要重写方法
 * resolveViewName()，这个方法的返回值是接口View，而View的职责就是使用model、request、response对象，
 * 并将渲染的视图（不一定是html，可能是json、xml、pdf）返回给浏览器
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-14 14:47
 **/
@Configuration
@EnableScheduling // 开启计划任务支持
@EnableWebMvc //@EnableWebMvc注解会开启一些默认配置，如一些ViewResolver或者MessageConverter等
// 1.@EnableWebMvc开启SpringMVC支持，若无此句，重写WebMvcConfigurerAdapter方法无效。
@ComponentScan("com.wisely.highlight_springmvc4")
// 2.继承WebMvcConfigurerAdapter类，重写其方法可对Spring MVC进行配置。
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver(){
        // JSP的ViewResolver，用来映射路径和实际页面的位置
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 3.addResourceLocations指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径。
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    //拦截器配置①
    @Bean //1 配置拦截器的Bean 这是自定义的
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    //拦截器配置②
    @Override //2 重写addInterceptors方法，注册拦截
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }

    // 页面转向
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/converter");
        registry.addViewController("/sse").setViewName("/sse");
        registry.addViewController("/async").setViewName("/async");
    }

    //MultipartResolver配置 文件上传
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }

    //访问http://localhost：8080/highlight_springmvc4/anno/pathvar/xx.yy，就可以接受“.”后面的yy了
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    /**
     * 配置自定义的HttpMessageConverter的Bean，在SpringMVC里注册HttpMessageConverter有两个方法：
     * 1.configureMessageConverters：重载会覆盖掉Spring MVC默认注册的多个HttpMessageConverter
     * 2.extendMessageConverters：仅添加一个自定义的HttpMessageConverter，不覆盖默认注册的HttpMessageConverter。
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }
    @Bean
    public MyMessageConverter converter(){
        return new MyMessageConverter();
    }

}
