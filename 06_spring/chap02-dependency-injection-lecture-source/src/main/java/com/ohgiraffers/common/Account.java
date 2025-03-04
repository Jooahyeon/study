package com.ohgiraffers.common;

public interface Account {
    // 추상화된 인터페이스에 의존해야 유지보수에 편함: 계좌가 바뀌더라도 memberDTO에 영향을 주지 않음
    // 추상메소드로 규약을 정함

    /* 설명. 잔액 조회*/
    String getBalance();

    /* 설명. 입금 */  //금액 더 커지면 long형 사용
    String deposit(int money);

    /* 설명. 출금 */
    String withDraw(int money);



}
