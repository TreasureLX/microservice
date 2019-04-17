package com.lx.springapplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@EnableAutoConfiguration
public class SpringBootEventDemo {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootEventDemo.class)
                .listeners(event -> {
                    System.out.println("监听到事件："+event.getClass().getSimpleName());
                })
                .run(args);
    }
}
