package com.wu.kong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableEurekaClient
// @EnableScheduling  激活注解
public class KongApplication {

    public static void main(String[] args) {

        SpringApplication.run(KongApplication.class, args);
    }

}
