package com.ohgirafferse.section02.encapsulation.problem2;

public class Application1 {
    public static void main(String[] args) {

        //캡슐화 => 유지보수를 위함 / 단일책임의 원칙
        Monster monster1 = new Monster();
        monster1.name = "드라큘라";
        // monster1.hp = 200;
        monster1.setInfo2(200);

    }
}
