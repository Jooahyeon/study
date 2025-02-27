package com.ohgiraffers.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class MemberDTO {
    // +) 어떤 계좌를 가진 회원이라 가정

    private int sequence;
    private String name;
    private String phone;
    private String email;
    private Account personalAccount;            // 개인 계좌 (인터페이스_규약으로 만듬) 의존의 대상이 추상화 된 인터페이스에 의존하는 것
    // 추상화된 인터페이스에 의존해야 유지보수에 편함: 계좌가 바뀌더라도 memberDTO에 영향을 주지 않음


}
