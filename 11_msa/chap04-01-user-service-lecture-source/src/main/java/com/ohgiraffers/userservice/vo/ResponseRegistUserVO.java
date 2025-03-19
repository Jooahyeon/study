package com.ohgiraffers.userservice.vo;


import lombok.Data;

/* 설명. 회원가입 요청 때와 달리 응답 시에는 비밀번호 대신 서버가 생성한 고유 회원 번호(userId)를 돌려준다 */
// 필드를 안맞춰주면 쓸데없는 것들까지 json형태로 바껴서 날아가면 지저분함 -> 응답 받는 값만 vo로 만들어야 함(그래야 json이 얘네만 바꿔)
@Data
public class ResponseRegistUserVO {
    private String email;
    private String name;
    private String userId;

}
