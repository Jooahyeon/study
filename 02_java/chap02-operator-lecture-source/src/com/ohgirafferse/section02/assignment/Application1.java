package com.ohgirafferse.section02.assignment;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 복합대입 연산자를 이해하고 활용할 수 있다. */
        //설명.
        //  *  대입연산자와 산술 복합 대입 연산자
        //  * '=', '*=', '-=', '/=' , '%=', '+='
        // *

        int num = 12;                           //12
        System.out.println("num = " + num);

        num = num + 3;                          //15
        System.out.println("num = " + num);

        num += 3;                               //18
        System.out.println("num = " + num);

        num -= 3;                               //15
        System.out.println("num = " + num);

        num *= 2;                               //30
        System.out.println("num = " + num);

        num /= 2;                               //15
        System.out.println("num = " + num);

        num %= 2;                               // 1
        System.out.println("num = " + num);

        num =- 5;   // equal(=) 기호는 왼쪽에 오면 단순 대입 기호가 된다.(주의) -5
        System.out.println("num = " + num);

        /*
        같은 의미를 가지나 사용하는 조건에 따라 맞는 방식으로 사용
        num = num + 1;
        num += 1;
        num++;   => 단항연산자 파트에서 다시!

         */


    }
}
