package com.primeton.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Wtq
 * @date 2019/8/4 - 17:32
 * 这里是我们的消费者端
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
public class ConsumerMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMainApplication.class,args);
    }
}
