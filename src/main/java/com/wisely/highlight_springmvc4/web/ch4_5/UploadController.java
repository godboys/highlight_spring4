package com.wisely.highlight_springmvc4.web.ch4_5;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * <p>
 * 文件上传控制器
 * </p>
 *
 * @Author yangjian
 * @Create 2019-6-21 15:03
 **/
@Controller
public class UploadController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    // 1.使用MultipartFile file接受上传的文件
    public @ResponseBody String upload(MultipartFile file) {
        try {
            // 2. 使用FileUtils.writeByteArrayToFile快速写文件到磁盘。
            FileUtils.writeByteArrayToFile(new File("e:/upload/"+ file.getName()),file.getBytes());
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "wrong";
        }
    }

    /*@RequestMapping(value = "/upload",method = RequestMethod.POST)
    // 1.使用MultipartFile file接受上传的文件
    public @ResponseBody String upload(HttpServletRequest request) {

        if (request instanceof MultipartHttpServletRequest) {
            try {
                MultipartFile file = (MultipartFile)request;
                // 2. 使用FileUtils.writeByteArrayToFile快速写文件到磁盘。
                FileUtils.writeByteArrayToFile(new File("e:/upload/"+ file.getName()),file.getBytes());
                return "ok";
            } catch (IOException e) {
                e.printStackTrace();
                return "wrong";
            }
        }
        return "wrong";
    }*/
}