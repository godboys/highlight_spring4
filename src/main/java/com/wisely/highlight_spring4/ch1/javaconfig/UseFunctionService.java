package com.wisely.highlight_spring4.ch1.javaconfig;

/**
 * <p>
 * 编写功能类的Bean
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-13 16:37
 **/
// 1.此处没有使用@Service声明Bean
public class UseFunctionService {
    // 2.此处没有使用@Autowired注解注入Bean
    FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }
    public String SayHello(String word){
        return functionService.sayHello(word);
    }
}