package com.fuyong.imwebtest.configp;


import com.fuyong.imwebtest.pojo.Person;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {
    @RabbitHandler
    public void process(Person person){
        System.out.println("Receiver :"+person.getAddress()+"---"+person.getName()+"---"+person.getAge());
    }
}
