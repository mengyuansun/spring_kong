package com.wu.kong.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumerTop {
    public static final String ACTIVEMQ = "nio://192.168.112.107:61618";
    //public static final String ACTIVEMQ = "tcp://192.168.112.107:61616";
    public static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("****我是1号消费者****");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ);
        //1:通过连接工厂，获得connection
        Connection connection = activeMQConnectionFactory.createConnection();
        //2:开启链接
        connection.start();
        //3:创建会话session
        //两个参数，第一个叫事务，，第二个叫签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4:创建目的地（具体是队列 还是topic）
        Topic topic = session.createTopic(TOPIC_NAME);
        //5:创建消费者
        MessageConsumer messageConsumer = session.createConsumer(topic);
        messageConsumer.setMessageListener((message -> {
            if (null != message && message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("*********消费者接收 topic 消息 by  监听器***********" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }

        }));
        System.in.read();  //保持控制台不灭
        messageConsumer.close();
        session.close();
        connection.close();
    }
}
