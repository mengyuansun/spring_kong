package com.wu.kong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/*
 * 实现读取远程配置文件
 *
 * */
@SpringBootApplication
@EnableConfigServer
public class KongApplication {

    public static void main(String[] args) {

        SpringApplication.run(KongApplication.class, args);
    }

}
