package com.ohgiraffers.listener.section01.contextlistener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
//로그 용도로도 많이 사용함
public class ContextListener implements ServletContextListener, ServletContextAttributeListener {
    public ContextListener() {
        System.out.println("context listener 인스턴스 생성!");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context init!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context destroy!");
    }

//    ServletContextAttributeListener 수정 삭제 뭐시기
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("attribute added!" + event.getName());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("attribute remove!");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("attribute replaced");
    }
}
