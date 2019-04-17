package com.lx.springapplication;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.GenericApplicationContext;

public class SpringEventListener {
    public static void main(String[] args) {
        GenericApplicationContext context=new GenericApplicationContext();
//        context.addApplicationListener((event)->{
//            System.err.println("监听事件==>"+event);
//        });
        //监听容器关闭事件
        context.addApplicationListener(new CloseListener());
        //监听容器刷新事件
        context.addApplicationListener(new RefreshedListener());
        //监听资自定义事件
        context.addApplicationListener(new MyEventListener());
        //启动Spring上下文
        context.refresh();
        //发布事件
        //ContextRefreshedEvent
        //PayloadApplicationEvent
        //ContextClosedEvent
        context.publishEvent(new MyEvent("Hello world"));
        //关闭应用上下文
        context.close();
    }

    //自定义监听器
    private static class CloseListener implements ApplicationListener<ContextClosedEvent> {

        @Override
        public void onApplicationEvent(ContextClosedEvent event) {
            System.out.println("监听到事件==>"+event);
        }
    }

    private static class RefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            System.out.println("监听到事件==>"+event);
        }
    }

    private static class MyEventListener implements ApplicationListener<MyEvent> {

        @Override
        public void onApplicationEvent(MyEvent event) {
            System.out.println("监听到自定义事件==>"+event);
        }
    }

    //自定义事件
    private static class MyEvent extends ApplicationEvent{

        public MyEvent(Object source) {
            super(source);
            System.out.println("发布事件==>"+source);
        }
    }
}


