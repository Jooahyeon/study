package com.ohgiraffers.section02.extend.vo;

/*설명. RabbitFarm 제네릭 클래스는 Rabbit 또는 Rabbit 하위 타입으로만 제네릭 타입을 지정할 수 있다.*/
public class RabbitFarm < T extends Rabbit >  {         //토끼 농장에 토끼만 들어가! 파충류 놉(타입안전성 구체화한 것)
    private T rabbit;

    public RabbitFarm() {
    }

    public RabbitFarm(T rabbit) {
        this.rabbit = rabbit;
    }

    public T getRabbit() {
        return rabbit;
    }

    public void setRabbit(T rabbit) {
        this.rabbit = rabbit;
    }
}
