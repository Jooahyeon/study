package com.ohgiraffers.common;

// 모든 어노테이션을 가진 lombok이라는 라이브러리 임포트
import lombok.*;
import org.springframework.context.annotation.Configuration;
// 매개변수 없는 기본 생성자
@NoArgsConstructor
// 모든 매개변수 가진 생성자
@AllArgsConstructor
@Setter
@Getter
@ToString

@Configuration("testConfig")
// +) 모든 섹션에서 활용할 클래스

public class MemberDTO {
    private int sequence;
    private String id;
    private String pwd;
    private String name;

}


