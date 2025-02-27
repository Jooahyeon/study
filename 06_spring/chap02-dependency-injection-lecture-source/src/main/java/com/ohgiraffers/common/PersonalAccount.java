package com.ohgiraffers.common;

public class PersonalAccount implements Account{
    // +)실제로 이 객체가 호출되면 어떻게 될 것이야?!를 볼 예졍 , 추상화...개념?
    private final int bankCode;             // 은행 코드
    private final String accNo;             // 계좌 번호
    private int balance;                    // 잔액
   // +) 기본생성자는 안됨 (매개변수 있는 생성자로 만들어야 한다)

    public PersonalAccount(int bankCode, String accNo) {
        this.bankCode = bankCode;
        this.accNo = accNo;
    }

    @Override
    public String getBalance() {
        return this.accNo + "계좌의 현재 잔액은 " + this.balance + "원 입니다.";
    }

    @Override
    public String deposit(int money) {
        String str = "";

        if (money >= 0) {
            this.balance += money;
            str = money + "원이 입금되었습니다. ";
        } else {
            str = "금액을 잚소 입력하셨습니다.";
        }
        return str;
    }

    @Override
    public String withDraw(int money) {
        String str = "";
        if (this.balance >= money) {
            this.balance -= money;
            str = money + "원이 출금되었습니다.";
        } else {
            str = "잔액이 부족합니다. 잔액을 확인해 주세요";
        }
        return str;
    }

    // 자신의 필드값을 내주도록 오버라이딩!
    @Override
    public String toString() {
        return "PersonalAccount{" +
                "bankCode=" + bankCode +
                ", accNo='" + accNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}
