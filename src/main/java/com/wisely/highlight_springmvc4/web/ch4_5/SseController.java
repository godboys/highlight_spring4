package com.wisely.highlight_springmvc4.web.ch4_5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * <p>
 * 基于SSE（Server Send Event服务端发送事件）
 * 的服务器端推送和基于Servlet 3.0+的异步方法特性，其中第一
 * 种方式需要新式浏览器的支持，第二种方式是跨浏览器的
 * </p>
 *
 * @Author yangjian
 * @Create 2019-6-24 10:49
 **/
// 基于SSE（Server Send Event服务端发送事件的服务器端推送
@Controller
public class SseController {

    // 1. 这里使用输出的媒体类型为text/event-stream，这是服务器端SSE的支持，本例演示每5秒钟向浏览器推送随机消息。
    @RequestMapping(value="/push",produces="text/event-stream")
    public @ResponseBody
    String push(){
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3" + r.nextInt() +"\n\n";
    }
}

