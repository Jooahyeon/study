package com.ohgiraffers.chap01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정파일을 따로 만들어주긴 해얗 ㅐ
// 키자마자 설정파일에서 키값을 불러오는지 확인하는 작업 (키자마자 콩이 됐다-> 수동으로 컨테이너를 만들지 않아도 됨)
@Configuration
public class SpringConfiguration {
    @Value("${test.value}") // 키값으로 찾아줌. ${} 표시 해줘야 함 왜지 어제 설명해주셨는데
    public String testValue;

    @Value("${test.age}")
    public String testAge;


    /* 설명. @Value는 시스템 환경변수도 불러올 수 있다.*/
    @Value("${user}")
    public String userName;

    @Bean
    public Object propertReadTest() {
        System.out.println("testValue: " + testValue);
        System.out.println("testAge: " + testAge);
        System.out.println("userName: " + userName);

        return new Object();
    }


}
