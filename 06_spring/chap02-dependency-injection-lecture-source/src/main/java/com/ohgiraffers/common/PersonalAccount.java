package com.ohgiraffers.common;

public class PersonalAccount implements Account{
    // +)실제로 이 객체가 호출되면 어떻게 될 것이야?!를 볼 예졍 ,
    // override가 된 것을 보고 필요한 속성을 아래와 같이 뽑아낸 것
    private final int bankCode;             // 은행 코드
    private final String accNo;             // 계좌 번호
    private int balance;                    // 잔액
    // final은 생성자까지는 초기화가 되야 정의 내릴 수 있음 (명시적 초기화, 초기화 블럭, 생성자 까지 거쳐 객체 생성되는데)
    // +) 기본생성자일때는 초기화가 안됨 (매개변수를 자동으로 만들어주지 않으므로 매개변수 있는 생성자로 만들어야 한다)


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
