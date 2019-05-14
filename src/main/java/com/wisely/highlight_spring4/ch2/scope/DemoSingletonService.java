package com.wisely.highlight_spring4.ch2.scope;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 编写Singleton的Bean。
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-13 17:46
 **/
@Service  // 1.默认为Singleton，相当于@Scope（“singleton”）
public class DemoSingletonService {
}