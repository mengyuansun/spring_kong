package com.wu.kong.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProducerQue {
    public static final String ACTIVEMQ = "tcp://192.168.112.107:61616";
    public static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException {

        //创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ);
        //通过连接工厂，获得connection
        Connection connection = activeMQConnectionFactory.createConnection();
        //开启链接
        connection.start();
        //创建会话session
        //两个参数，第一个叫事务，，第二个叫签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地（具体是队列 还是topic）
        Queue queue = session.createQueue(QUEUE_NAME);
        //创建消息的生产者
        MessageProducer messageProducer = session.createProducer(queue);
        //使用  messageProducer  生产5条消息发送到MQ的队列里面
        for (int i = 1; i <= 5; i++) {
            //创建消息
            TextMessage textMessage = session.createTextMessage("MSG------" + i);
            //通过  messageProducer  发送mq
            messageProducer.send(textMessage);
        }
        messageProducer.close();
        session.close();
        connection.close();
        System.out.println("**********消息发布到队列**********");
    }
}
