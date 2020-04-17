package com.ribbonprovider.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {
    //获取当前端口配置
    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello Word from port :" + port;
    }
}
