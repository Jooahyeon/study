package com.ohgiraffers.section01.intro;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 람다식에 대해 이해하고 활용할 수 있다.(feat. Functional Interface_어노테이션을 달 수 있음) */
    //Functional Interface 해당 인터페이스로만 람다식 가능


        /*목차. 1. 인터페이스를 구현하는 클래스로 하위 구현체(Calculatorimpl)를 만드는 방법(feat.자식 클래스 필요)_이름있는 버전 */
//        Calculator cal = new Calculator();
        Calculator cal = new CalculatorImpl();
        System.out.println("10과 20의 합은? " + cal.sumTwoNumbers(10, 20));         //동적바인딩 발생

        /* 목차. 2. 익명 클래스를 활용한 방식(인터페이스 타입으로 하위 구현체 생성)
         *                               (자식 (구현)클래스 없애기)
        *   => 다른타입을 쓰지 않고 해당 객체로 이름이 없는 클래스를 만든 것(일회성으로 사용)*/
        Calculator cal2 = new Calculator() {
            @Override
            public int sumTwoNumbers(int first, int second) {
                return 0;
            }
        };
        System.out.println("10과 20의 합은(익명클래스)? " + cal2.sumTwoNumbers(20, 30));

        /* 목차. 3. 람다식을 활용한 방식 (메소드명 없애기 _ 정석)
        *  설명.
        *   람다식은 익명함수로 이름을 별도로 작성하지 않지만 인터페이스의 하위 구현체를 생성하며
        *   유일하게 있는 추상메소드를 오버라이디이 하는 개념이기 때문에 익명 함수가 가능하다.
        *   즉, 람다식을 활용하기 위한 인터페이스는 추상 메소드를 단 하나만 가져야 한다.
        *   그런 인터페이스를 FunctionalInterface라고 한다.
        *
        *  설명.
        *   기본 람다식 규칙  (다 외우려고 하기보다 예시를 써보는게 나음)
        *   1. 매개변수의 소괄호(())는 생략할 수 없지만 매개변수가 하나인 추상메소드는 소괄호도 생략
        *       가능하다(ex. x->1 + x;)
        *   2. 구현하는 메소드의 바디부분에서 실행 구문이 하나일 경우 중괄호({})가 생략 가능하다.
        *   3. 실행된 마지막 구문이 리터럴 형태로 끝나고 추상메소드에 반황형이 있을 경우 return이
        *       생략 가능하다.
        *  */
//        Calculator cal3 = (int first, int second) -> {return first + second;};
        Calculator cal3 = (first, second) -> first + second;                  //타입, 중괄호(2개 이상일 땐 쓰기), 리턴식, 세미콜론 삭제 가능(자동으로 판별)
//        표현식 : 리터럴 값 하나가 나오게 하는 것


        System.out.println("2와 4의 합은(람다식)? " + cal3.sumTwoNumbers(2, 4));

    }
}
