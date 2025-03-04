package com.ohgiraffers.section01.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// +) POJO (Plain Old Java Object)
// +) @Configuration("config1") 이렇게 하면 spring 어노테이션 설정용 클래스가 된 것
@Configuration("config1")
public class ContextConfiguration {

    // +) 콩 이름 = 메소드명
    @Bean("member")
    public MemberDTO getMember() {

        return new MemberDTO(1, "user01", "pass01", "홍길동");
    }

}
