package com.ohgirafferse.section02.encapsulation.problem2;

public class Monster {

    // 캡슐화 설명
    String name;
//    int hp;
    int mp;
    //결합도가 낮아야 유지보수에 좋다(다른데 문제를 일으키지 않기 때문에 )

    public void setInfo1(String info1) {
        this.name = info1;
    }

    public void setInfo2(int info2) {
        this.mp = info2;
    }
}
