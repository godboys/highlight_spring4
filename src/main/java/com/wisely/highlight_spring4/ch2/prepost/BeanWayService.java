package com.wisely.highlight_spring4.ch2.prepost;

/**
 * <p>
 * 使用@Bean形式的Bean。
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-14 9:45
 **/
public class BeanWayService {

    public void init(){
        System.out.println("@Bean-init-method");
    }

    public BeanWayService(){
        super();
        System.out.println("初始化构造函数-BeanWayService");
    }

    public void destroy(){
        System.out.println("@Bean-destory-method");
    }

}