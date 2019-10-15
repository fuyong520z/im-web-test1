package com.fuyong.imwebtest.configp;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    public void send1() {
        String context = "hi, i am message 1";
        this.amqpTemplate.convertAndSend("topicExchange", "topic.message", context);
    }


    public void send2() {
        String context = "hi, i am messages 2";
        this.amqpTemplate.convertAndSend("topicExchange", "topic.messages", context);
    }
}
