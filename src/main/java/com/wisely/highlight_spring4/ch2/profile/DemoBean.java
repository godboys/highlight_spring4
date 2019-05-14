package com.wisely.highlight_spring4.ch2.profile;

/**
 * <p>
 * 示例Bean
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-14 10:46
 **/
public class DemoBean {

    private String content;

    public DemoBean(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}