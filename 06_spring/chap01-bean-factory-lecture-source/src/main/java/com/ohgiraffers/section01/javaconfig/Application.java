package com.ohgiraffers.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// +) 스프링으로 넘어오면 설정용 파일(클래스,xml파일)이 필요함
// +) class ContextConfiguration로 설정파일 생성

public class Application {
    public static void main(String[] args) {
        // +) 우리의 설정(메타데이터)을 갖고 컨테이너를 만든 것
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // +) getBeanDefinitionNames : 콩 이름 확인
        String[] beanNames = context.getBeanDefinitionNames(); // +) context : container개념
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }
    }
}
