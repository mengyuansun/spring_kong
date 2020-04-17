package com.wu.kong.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumerQue {
    public static final String ACTIVEMQ = "tcp://192.168.112.107:61616";
    public static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException, IOException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ);
        //1:通过连接工厂，获得connection
        Connection connection = activeMQConnectionFactory.createConnection();
        //2:开启链接
        connection.start();
        //3:创建会话session
        //两个参数，第一个叫事务，，第二个叫签收
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        //4:创建目的地（具体是队列 还是topic）
        Queue queue = session.createQueue(QUEUE_NAME);
        //5:创建消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);
        /*
         * 同步阻塞方式（receive()）
         * 订阅者或接收者调用,MessageConsumer的receive()方法来接收消息
         * receive方法能在接收到消息之前（或 超时之前）将一直阻塞
         * */
//        while(true){
//            TextMessage textMessage = (TextMessage) messageConsumer.receive(); //receive（4000L）  设置过期时间
//            if (null != textMessage){
//                System.out.println("********消费者收到消息********"+textMessage.getText());
//            }else {
//                break;
//            }
//
//        }
//        messageConsumer.close();
//        session.close();
//        connection.close();
        //通过监听的方式来接收消息
        messageConsumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (null != message && message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;

                    try {
                        System.out.println("*********消费者接收消息 by  监听器***********" + textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.in.read();  //保持控制台不灭
        messageConsumer.close();
        session.commit();
        session.close();
        connection.close();

//        try {
//            // ok session.commit
//        }catch (Exception e){
//            e.printStackTrace();
//            session.rollback();
//        }finally {
//            if (null !=session){
//                session.close();
//            }
//        }


    }
}
