package com.ohgiraffers.section02.annotation.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary //@Primary (서비스 콩에는 피카츄가 주입된 상태) 생성자 주입에 원픽
@Component
public class Pikachu implements Pokemon {
    @Override
    public void attack() {
        System.out.println("피카츄 백만볼트");

    }
}
