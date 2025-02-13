package com.ohgiraffers.section01.intro;

/* 설명. FunctionalInterface만 람다식으로 적용 가능하다. */

@FunctionalInterface // 추상메소드가 반드시 하나만 존재하는 인터페이스를 만들고 출발해야 함.
public interface Calculator {
    int sumTwoNumbers(int first, int second);
//    void test();
}
