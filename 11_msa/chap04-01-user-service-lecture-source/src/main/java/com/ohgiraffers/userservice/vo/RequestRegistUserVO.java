package com.ohgiraffers.userservice.vo;

import lombok.Data;

@Data    // 리팩토링할때는 바꾸1!! 이렇게 통으로 쓰는거 지양하셈
// 응답 받는 것
// post 요청 보내는 것과 키값이 맞춰야 해
public class RequestRegistUserVO {
    private String email;
    private String name;
    private String pwd;

}
