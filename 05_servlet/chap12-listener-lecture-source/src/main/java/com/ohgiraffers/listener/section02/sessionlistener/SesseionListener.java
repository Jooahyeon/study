package com.ohgiraffers.listener.section02.sessionlistener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
// +) 사물함에 담길 때마다 내용이 뜸
public class SesseionListener implements HttpSessionListener, HttpSessionAttributeListener {

    public SesseionListener() {
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("attributeAdded");
        System.out.println("session에 추가된 attr: " + event.getName() + ", value" + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("attributeRemoved");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("attributeReplaced");
    }
}
