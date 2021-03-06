package com.wisely.highlight_spring4.ch2.el;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.apache.commons.io.IOUtils;
/**
 * <p>
 * 演示配置类
 * </p>
 *
 * @Author yangjian
 * @Create 2019-5-13 18:02
 **/
@Configuration
@ComponentScan("com.wisely.highlight_spring4.ch2.el")
@PropertySource("classpath:com/wisely/highlight_spring4/ch2/el/test.properties")
public class ElConfig {

    @Value("I Love You!") // 1.注入普通字符串
    private String normal;
    @Value("#{systemProperties['os.name']}") // 2.注入操作系统属性
    private String osName;
    @Value("#{ T(java.lang.Math).random() * 100.0 }") // 3.注入表达式结果
    private double randomNumber;
    @Value("#{demoService.another}") // 4.注入其他Bean属性
    private String fromAnother;
    @Value("classpath:com/wisely/highlight_spring4/ch2/el/test.txt") // 5.注入文件资源。
    private Resource testFile;
    @Value("http://www.baidu.com") // 6.注入网址资源
    private Resource testUrl;
    // 7.注入配置文件
    @Value("${book.name}")
    private String bookName;
    @Autowired
    private Environment environment; // 7.注入配置文件
    // 7.注入配置文件  注入配置配件需使用@PropertySource指定文件地址，
    // 若使用@Value注入，则要配置一个PropertySourcesPlaceholderConfigurer的Bean。
    //@Value（"${book.name}"）使用的是“$”，而不是“#”。注入Properties还可从Environment中获得。
    @Bean // 7.注入配置文件
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }
    public void outputResource() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}