package com.wisely.highlight_spring4.ch2.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * <p>
 * 自定义事件
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-14 13:34
 **/
public class DemoEvent extends ApplicationEvent {

    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}