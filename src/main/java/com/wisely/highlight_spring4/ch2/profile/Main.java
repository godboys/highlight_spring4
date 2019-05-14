package com.wisely.highlight_spring4.ch2.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;

/**
 * <p>
 * 运行
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-14 11:01
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev"); // 1.先将活动的Profile设置为prod
        context.register(ProfileConfig.class); // 2.后置注册Bean配置类，不然会报Bean未定义的错误。
        context.refresh(); // 3.刷新容器
        DemoBean demoBean = context.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());
        context.close();
    }
}