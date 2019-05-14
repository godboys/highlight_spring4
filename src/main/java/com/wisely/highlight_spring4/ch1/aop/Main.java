package com.wisely.highlight_spring4.ch1.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * 运行
 * 基于注解拦截和基于方法规则拦截两种方式，演示一种模拟记录操作的日志系统的实现。
 * 其中注解式拦截能够很好地控制要拦截的粒度和获得更丰富的信息，
 * Spring本身在事务处理（@Transcational）和数据缓存（@Cacheable等）上面都使用此种形式的拦截。
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-13 17:28
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
        demoAnnotationService.add();
        demoMethodService.add();
        context.close();
    }
}