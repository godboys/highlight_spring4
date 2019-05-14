package com.wisely.highlight_spring4.ch1.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * 运行
 * 在本节演示基于注解的Bean的初始化和依赖注入，Spring容器类选用AnnotationConfigApplicationContext。
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-13 16:15
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.SayHello("di"));
        context.close();
    }
}