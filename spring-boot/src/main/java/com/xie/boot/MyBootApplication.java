package com.xie.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration()//启用自动配置注解
@ComponentScan({"com.xie"})
public class MyBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBootApplication.class);
    }
}
