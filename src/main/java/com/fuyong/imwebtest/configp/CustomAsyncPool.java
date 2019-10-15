package com.fuyong.imwebtest.configp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class CustomAsyncPool extends WebMvcConfigurerAdapter {
   @Bean(name = "asyncPoolTaskExecutor")
    public ThreadPoolTaskExecutor getAsyncThreadPoolTaskExecutro(){
       ThreadPoolTaskExecutor taskExecutor= new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(20);
        taskExecutor.setMaxPoolSize(20);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.setKeepAliveSeconds(200);
        taskExecutor.setThreadNamePrefix("callable-");
        //线程池对拒绝任务（无线程可用）的处理策略 目前只支持AbortPolicy、CallerRunsPolicy:默认为后者
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
   }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
       //处理callable 超时
        configurer.setDefaultTimeout(10*1000);
        configurer.registerCallableInterceptors(timeoutInterceptor());
        configurer.setTaskExecutor(getAsyncThreadPoolTaskExecutro());
    }
    @Bean
    public TimeoutCallableProcessingInterceptor timeoutInterceptor(){
       return new TimeoutCallableProcessingInterceptor();
    }
}
