package com.ohgirafferse.section02.encapsulation.problem;

//객체를 찍어내기 위한 틀 = 클래스
public class Monster {
    String name;
    int hp;

    public void setHp(int hp) {
        if(hp >= 0) {
            this.hp = hp;                           //this. = 메소드를 호출하기 위한 객체(monster2)
        } else {
            this.hp = 0;
        }
    }
}
