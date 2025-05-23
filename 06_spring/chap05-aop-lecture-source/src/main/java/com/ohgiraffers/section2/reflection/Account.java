package com.ohgiraffers.section2.reflection;

public class Account {
    private String bankCode;
    private String accNo;
    private String accPwd;
    private int balance;

    public Account() {
    }

    public Account(String bankCode, String accNo, String accPwd) {
        this.bankCode = bankCode;
        this.accNo = accNo;
        this.accPwd = accPwd;
    }


    public Account(String bankCode, String accNo, String accPwd, int balance) {
        this(bankCode, accNo, accPwd);
        this.balance = balance;
    }


    /* 설명. 잔액 조회 */

    public String getBalance() {
        return this.accNo + "계좌의 잔액은 " + this.balance;
    }

    /* 설명. 입금 */
    public String deposit (int money) {
        String str = "";
        if (money >= 0) {
            this.balance += money;
            str = money + "원이 입금되었습니다.";
        } else {
            str = "금액을 잘못 입력하셨습니다";
        }
        return str;

    }

    /* 설명. 출금 */
    public String withdraw(int money) {
        String str = "";
        if (balance >= money) {
            balance -= money ;
            str = money + "원이 출금되었습니다. ";
        } else {
            str = "잔액이 부족합니다. 확인바람";
        }
        return str;
    }



}
