package com.example.demo.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Component
public class Producer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMsgToQueue(String destinationName,String message){
        System.out.println("发送Queue--->"+message);
        Destination destination=new ActiveMQQueue(destinationName);
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

    public void sendMsgToTopic(String destinationName,String message){
        System.out.println("发送Topic--->"+message);
        Destination destination=new ActiveMQTopic(destinationName);
        jmsMessagingTemplate.convertAndSend(destination,message);
    }
}
