package com.wisely.highlight_spring4.ch2.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * 运行
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-13 17:49
 **/
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        DemoPrototypeService s1 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService s2 = context.getBean(DemoPrototypeService.class);
        DemoSingletonService p1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService p2 = context.getBean(DemoSingletonService.class);
        System.out.println("s1与s2是否相等：" + s1.equals(s2));
        System.out.println("p1与p2是否相等：" + p1.equals(p2));
        context.close();
    }
}