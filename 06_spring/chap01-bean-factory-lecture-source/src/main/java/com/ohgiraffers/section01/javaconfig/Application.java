package com.ohgiraffers.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        // +) 우리의 설정(메타데이터)을 갖고 컨테이너를 만든 것
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames(); // +) context : container개념
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }
    }
}
