package com.mljr.feign.consumer.controller;

import com.mljr.feign.consumer.depend.RemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * Author:daoyuanXiong
 * Description:
 * Date:Created in 下午4:24 2017/8/8
 * Copyright (c)  daoyuan.xiong@mljr.com All Rights Reserved.
 */
@RestController
public class FeignConsumerController {

    @Autowired
    private RemoteClient client;

    @GetMapping({"/", ""})
    public String index(HttpServletRequest request) {
        System.out.println("<<<<<<<<<<<<<token:"+request.getHeader("token")+">>>>>>>>>>>>>");
        return "Hi,dy_bom,this is feign-consumer!";
    }

    @GetMapping("/index")
    public String feignIndex() {
        String str =client.index();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<feign调用返回值："+str+">>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return str;
    }
}


