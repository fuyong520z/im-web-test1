package com.fuyong.imwebtest.configp;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitmqConfig {

    @Bean
    public org.springframework.amqp.core.Queue helloQueue() {
        return  new Queue("hello");
    }
}
