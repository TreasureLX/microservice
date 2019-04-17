package com.lx.springapplication;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringAnnotationDemo {
    public static void main(String[] args) {
        //注解驱动
        //@Bean @Configuration
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
        applicationContext.register(SpringAnnotationDemo.class);
        applicationContext.refresh();
        System.out.println(applicationContext.getBean(SpringAnnotationDemo.class));
    }
}
