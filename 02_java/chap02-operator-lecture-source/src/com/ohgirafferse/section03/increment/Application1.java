package com.ohgirafferse.section03.increment;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 단항 연산자이자 증감연산자에 대해 이해하고 활용할 수 있다. */
        //커피 퀴즈~

        int num = 20;
        System.out.println("num = " + num);

        num++;          //후위 연산자 (할 위 -> 연산을 나중에 하겠다~)  21
        System.out.println("num = " + num);

        ++num;          //전위 연산자  22
        System.out.println("num = " + num);

        num--;          //21
        System.out.println("num = " + num);

        --num;          //20
        System.out.println("num = " + num);

        // (me) 전위, 후위 연산자 구분 이유 -> 다른 연산 또는 출력문에서 쓰일 때는 차이가 있다
        /*설명. 다른 연산자와 함께 쓰이거나 출력문 안에서는 전위/후위 연산자가 해석의 차이를 일으킨다. */
        int firstNum = 20;
        int result = firstNum++ + 3;                          // 후위 연산자는 다른 연산이 끝난 후에 연산해라
        System.out.println("result = " + result);             // 23
        System.out.println("firstNum = " + firstNum);         // 21
        System.out.println("firstNum++ = " + firstNum++);     // 21   + 1(출력 후에 연산이 됨)
        System.out.println("firstNum = " + firstNum);         // 22

    }
}
