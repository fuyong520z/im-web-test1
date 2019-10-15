package com.fuyong.imwebtest.controller;

import com.fuyong.imwebtest.configp.exception.CustomAsyncRquestTimeoutException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

@Controller

public class HelloController {

    @RequestMapping("index")
    public  String index(){
        return  "index";
    }


    @RequestMapping("/callable")
    @ResponseBody
    public Callable<String> getcallable(){
        System.out.println("外部线程"+Thread.currentThread().getName());
        return new Callable<String>() {
            @Override
            public String call() throws CustomAsyncRquestTimeoutException {
                System.out.println("内部线程:"+Thread.currentThread().getName());
                //休眠三秒钟
                try {
                    Thread.sleep(11*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "helloWorld";
            }
        };
    }





}
