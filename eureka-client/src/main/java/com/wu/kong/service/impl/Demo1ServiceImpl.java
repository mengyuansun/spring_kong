package com.wu.kong.service.impl;

import com.wu.kong.model.User;
import com.wu.kong.service.Demo1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Demo1ServiceImpl implements Demo1Service {
    @Override
    public void init() {

    }

    @Override
    public User showName() {
        User user = new User();
        user.setAge(22);
        user.setName("大远哥");
        return user;
    }
}
