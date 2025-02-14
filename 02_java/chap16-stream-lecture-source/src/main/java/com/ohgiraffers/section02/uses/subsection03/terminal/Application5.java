package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Application5 {
    public static void main(String[] args) {

        /*설명. 메소드 참조 관련 추가(람다식 관련)*/
        BiConsumer<Member, String> biConsumer;
        biConsumer = Member::setMemberId;
        biConsumer = (x, y) -> x.setMemberId(y);

        Consumer<String> consumer;
        Member m = new Member("1", "홍길동");
        consumer = m::setMemberId;
        consumer = (x) -> m.setMemberId(x);
        // 객체가 정해져서 람다식을 쓸거면 참조자료형
    }
}
