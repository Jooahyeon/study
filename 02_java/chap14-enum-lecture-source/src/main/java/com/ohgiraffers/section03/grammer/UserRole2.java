package com.ohgiraffers.section03.grammer;

import java.util.Scanner;

public enum UserRole2 {
    //값을 부여 가능
    GUSET("게스트"),
    CONSUMER("구매자"),
    PRODUCER("판매자"),
    ADMIN("관리자");

    private final String DESCRIPTION;

    UserRole2(String description) {
        DESCRIPTION = description;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }
}
