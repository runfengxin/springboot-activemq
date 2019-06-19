package com.example.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

    @JmsListener(destination = "test.queue")
    public void receiveMsg(String text){
        System.out.println("收到消息----<"+text);
    }

    @JmsListener(destination = "queue",containerFactory = "queueListenerFactory")
    public void receiveQueue(String text) {
        log.info("consumer收到queue信息:{}",text);
    }

    @JmsListener(destination = "topic",containerFactory = "topicListenerFactory")
    public void receiveTopic(String text) {
        log.info("consumer收到topic信息:{}",text);
    }

}
