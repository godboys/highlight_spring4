package com.wisely.highlight_spring4.ch1.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 使用功能类的Bean
 * 1.使用@Service注解声明当前UseFunctionService类是Spring管理的一个Bean。
 * 2.使用@Autowired将FunctionService的实体Bean注入到UseFunctionService中，让UseFunctionService具备
 * FunctionService的功能，此处使用JSR-330的@Inject注解或者JSR-250的@Resource注解是等效的。
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-13 16:08
 **/
@Service
public class UseFunctionService {

    @Autowired
    private FunctionService functionService;

    public String SayHello(String word){
        return functionService.sayHello(word);
    }
}