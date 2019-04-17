package com.lx.springapplication;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

public class SpringMulticaster {
    public static void main(String[] args) {
        ApplicationEventMulticaster multicaster=new SimpleApplicationEventMulticaster();
        multicaster.addApplicationListener(event -> {
            System.out.println("监听到事件"+event);
        });
        //发布广播事件
        multicaster.multicastEvent(new PayloadApplicationEvent<>("Hello","world"));
        multicaster.multicastEvent(new MyEvent("Hello world"));
    }

    private static class MyEvent extends ApplicationEvent {

        public MyEvent(Object source) {
            super(source);
            System.out.println("发布事件==>"+source);
        }
    }
}
