package com.wisely.highlight_spring4.ch2.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 事件发布类
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-14 13:44
 **/
@Component
public class DemoPublisher {

    @Autowired
    ApplicationContext applicationContext; // 1.注入ApplicationContext用来发布事件。

    public void publish(String msg) {
        applicationContext.publishEvent(new DemoEvent(this, msg)); // 2.使用ApplicationContext的publishEvent方法来发布。
    }





}