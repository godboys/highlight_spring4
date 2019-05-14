package com.wisely.highlight_spring4.ch2.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 编写Prototype的Bean
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-13 17:47
 **/
@Service
@Scope("prototype")  //声明Scope为Prototype。每次调用新建一个Bean的实例。
public class DemoPrototypeService {
}