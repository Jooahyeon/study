package com.ohgiraffers.listener.section02.sessionlistener;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class UserDTO implements HttpSessionBindingListener {
    // HttpSessionBindingListener 어떤 객체가 binding되면 담기는 것

    private String name;
    private int age;

    public UserDTO() {
    }

    public UserDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // +) 여기서 변수로 Count해주면서 활용 가능
    // 해당 객체가 담길 때마다 추가 기능을 붙일 수 있는 것
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("UserDTO 객체가 담김");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("UserDTO 객체가 제거됨");
    }
}
