package com.wu.kong.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class SpringMQ_Consumer {
    @JmsListener(destination = "${myqueue}")  //监听 此队列
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("********消费者收到消息： "+textMessage.getText());
    }
}
