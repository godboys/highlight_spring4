package com.wisely.highlight_springmvc4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

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
@EnableWebMvc //@EnableWebMvc注解会开启一些默认配置，如一些ViewResolver或者MessageConverter等
@ComponentScan("com.wisely.highlight_springmvc4")
public class MyMvcConfig {

    public InternalResourceViewResolver viewResolver(){
        // JSP的ViewResolver，用来映射路径和实际页面的位置
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
}


/*可能读者对路径前缀配置为/WEB-INF/classes/views/有些奇怪，怎么和我开发的目录不一致？
    因为看到的页面效果是运行时而不是开发时的代码，运行时代码会将我们的页面自动编译到/WEB-INF/classes/views/下*/
