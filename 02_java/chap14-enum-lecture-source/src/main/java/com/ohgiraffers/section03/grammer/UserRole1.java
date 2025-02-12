package com.ohgiraffers.section03.grammer;

public enum UserRole1 {
    GUEST,
    CONSUMER,
    PROCEDUCER,
    ADMIN;

    /*설명. 각 필드에 들어갈 객체들에 단순 메소드 하나 추가해보기 */
    public String getNameTolowerCase() {            //소문자변환
        return this.name().toLowerCase();
    }
}
