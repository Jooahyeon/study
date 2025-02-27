package com.ohgiraffers.section01.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("config1")
public class ContextConfiguration {

    @Bean("member")
    public MemberDTO getMember() {
        return new MemberDTO(1, "user01", "pass01", "홍길동");
    }

}
