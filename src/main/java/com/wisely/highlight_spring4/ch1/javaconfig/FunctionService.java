package com.wisely.highlight_spring4.ch1.javaconfig;

/**
 * <p>
 * 编写功能类的Bean
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-13 16:36
 **/
//此处没有使用@Service声明Bean
public class FunctionService {
    public String sayHello(String word){
        return "Hello " + word +" !";
    }
}