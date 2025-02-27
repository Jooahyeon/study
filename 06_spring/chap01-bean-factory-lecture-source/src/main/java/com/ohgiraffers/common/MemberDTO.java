package com.ohgiraffers.common;

import lombok.*;
import org.springframework.context.annotation.Configuration;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Configuration("testConfig")

public class MemberDTO {
    private int sequence;
    private String id;
    private String pwd;
    private String name;

}


