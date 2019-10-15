package com.fuyong.imwebtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fuyong.imwebtest.dao")
public class ImWebTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImWebTestApplication.class, args);
    }

}
