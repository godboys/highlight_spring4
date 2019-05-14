package com.wisely.highlight_spring4.ch1.di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 配置类
 * 1.@Configuration声明当前类是一个配置类
 * 2.使用@ComponentScan，自动扫描包名下所有使用@Service、@Component、@Repository和@Controller的类，并注册为Bean。
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-13 16:12
 **/
@Configuration
@ComponentScan("com.wisely.highlight_spring4.ch1.di")
public class DiConfig {
}