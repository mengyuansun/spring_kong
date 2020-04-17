package com.wu.kong.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;


@Component
public class SpringMQ_Produce {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Scheduled(fixedDelay = 3000)  //定时发送
    public void produceMsg() {
        jmsMessagingTemplate.convertAndSend(queue, "****: " + UUID.randomUUID().toString().substring(0, 6)); //convertAndSend 与send相比 可以直接加转换+ 发送
    }

}
