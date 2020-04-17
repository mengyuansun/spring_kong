package com.consumer.myribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class HellloConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("helloworld")
    public String helloworld() {
        return restTemplate.getForEntity("http://RIBBON-SERVICE/hello", String.class).getBody();
    }
}
