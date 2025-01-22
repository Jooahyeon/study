package com.ohgiraffers.section01.method;

public class Application3 {

    static int global = 10;                     // 메소드와 별도로 형제격, 모든 메소드를 쓸 수 있으니 전역변수라 불림
                                                // (메소드가 상태에 영향 없이 살아 있음) 변수도 위치마다 고려해서 사용해야 함

    public static void main(String[] args) {

        /* 수업목표. 메소드 전달인자(argument) 와 매개변수(parameter)에 대해 이해하고 메소드 호출 시 활용할 수 있다. */
        /* 설명.
         *  변수를 선언한 위치에 따라 구분할 수도 있다.
         *  1. 지역변수
         *  2. 전역변수
         *  3. 매개변수
        * */

        System.out.println("전역 변수: " + global);     // 메소드와 별도로 형제격 (메소드가 상태에 영향 없이 살아 있음)

        Application3 app3 = new Application3();
        app3.testMehod(13);                      // '20' => 던지는 수를 전달인자 (argument)
        app3.testMehod(11);
        app3.testMehod('a');

        int local = 20;
        System.out.println("지역 변수: " + local);
    }

    public void testMehod(int age) {            //매개변수(parameter) : 전달한 값을 어떻게 쓸지 매개체 역할을 해줌,
        System.out.println("당신의 나이는 " + age + "세 입니다.");
    }

}
