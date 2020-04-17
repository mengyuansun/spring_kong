package com.wu.kong.controller;


import com.wu.kong.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wu.kong.service.Demo1Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class Demo1Controller {

    @Autowired
    public Demo1Service demo1Service;

    @RequestMapping("/ShowName")
    public User ShowName() {

        User user = this.demo1Service.showName();
        System.out.println("sun");
        System.out.println(user.name);
        return user;
    }


}
