package com.wisely.highlight_spring4.ch1.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <p>
 * 配置类
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-13 17:27
 **/
@Configuration
@ComponentScan("com.wisely.highlight_spring4.ch1.aop")
@EnableAspectJAutoProxy  // 1.使用@EnableAspectJAutoProxy注解开启Spring对AspectJ代理的支持。
public class AopConfig {
}