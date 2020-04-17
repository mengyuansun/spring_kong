package com.wu.kong.demo;

import org.apache.activemq.broker.BrokerService;

public class Broker {
    public static void main(String[] args) throws Exception {
        //ActivateMQ也支持在虚拟机中通讯，嵌入broker
        BrokerService brokerService = new BrokerService();
        //将activateMQ嵌入到java程序中
        brokerService.setUseJmx(true);
        //现在是将activateMQ嵌入到java程序中，所以使用本机
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();


    }
}
