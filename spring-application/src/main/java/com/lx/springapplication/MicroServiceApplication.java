package com.lx.springapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
@ComponentScan
public class MicroServiceApplication {

    public static void main(String[] args) {
//        SpringApplication.run(MicroServiceApplication.class, args);
//        new SpringApplicationBuilder(MicroServiceApplication.class)
//                .properties("server.port=0").run(args); //FluentAPI/

        SpringApplication application=new SpringApplication(MicroServiceApplication.class);
        Map<String,Object> properties=new LinkedHashMap<>();
        properties.put("server.port",0);
        application.setDefaultProperties(properties);
        application.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext applicationContext=application.run(args);
        System.out.println(applicationContext);
        System.out.println(applicationContext.getBean(MicroServiceApplication.class));
    }

}
