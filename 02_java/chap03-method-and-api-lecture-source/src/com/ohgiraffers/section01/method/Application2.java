package com.ohgiraffers.section01.method;

public class Application2 {
    public static void main(String[] args) {
        /*
        non-static method를 호출하는 방법
        자바는 class->static 순으로 인지함
        객체파트에서 다시 다룰 것
         */

        System.out.println("main() 시작됨 ...");

        /*설명. non-static 메소드인 경우 메소드를 new 연산자로 인지시켜 호출할 수 있다. */

        Application2 app = new Application2();             //클래스의 내부를 밝혀준다의 의미정도만 알 것(대략적으로 훑어본다_목차정도)
        app.methodA();                                     // '.' 의 의미는 접근 연산자
        app.methodB();

        System.out.println("main() 종료됨 ...");
    }

    public void methodA() {
        System.out.println("methodA() 시작됨 ...");

        System.out.println("methodA() 종료됨 ...");
    }
    public void methodB() {
        System.out.println("methodB() 시작됨 ...");

        System.out.println("methodB() 종료됨 ...");
    }

}

