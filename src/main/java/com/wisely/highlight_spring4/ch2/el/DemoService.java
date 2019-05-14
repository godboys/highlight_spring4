package com.wisely.highlight_spring4.ch2.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 需被注入的Bean
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-13 18:00
 **/
@Service
public class DemoService {

    @Value("其他类的属性")  // 1.此处为注入普通字符串
    public String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}