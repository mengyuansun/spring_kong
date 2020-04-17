package com.wu.kong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class KongApplication {

    public static void main(String[] args) {
        SpringApplication.run(KongApplication.class, args);
    }

}
