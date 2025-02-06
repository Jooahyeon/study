package com.ohgirafferse.section01.exception;

import org.w3c.dom.ls.LSOutput;

public class Application {

    public static void main(String[] args) throws ArithmeticException {

        /* 수업목표. 예외에 대해 이해하고 이를 처리하기 위한 문법을 활용할 수 있다.*/
        /*설명.
        *  1. throws를 통한 위임
        *  2. try-catch를 통한 처리
        * */
        ExceptionTest e = new ExceptionTest();

        /*목차. 1. throws로 처리 시 */
//        et.checkEnoughMoney(10000, 50000);   //우리가 하는게 아닌 jvm이 처리해줌

        /* 목차. 2. try-catch로 처리 시 */
//        try{

        /*설명. try블럭은 처리 할 예외가 발생할 적당한 범위를 감싼다. */
//        et.checkEnoughMoney(10000, 50000);
////        et.checkEnoughMoney(10000, 50000);
//            System.out.println("예외가 없군, 돈이 많으신가봐요");
//    } catch (ArithmeticException e) {
// catch로 받은게 객체 e
//            /* 설명.
//            *   try 블럭에서 발생한 예외(객체)를 처리하는 부분 (내 마음대로 처리 가능)
//            *   예외 객체를 활용하게 되면 해당 예외 객체의 메소드를 사용할 수 있다.
////            *   */
////            System.out.println("예외가 발생했군요!");   //출력을 발생시키겠다고 처리
////            System.out.println(" rm dPdhlsms " + e.getMessage());
////            System.out.println("거 돈 좀 넉넉히 들고 다닙시다.");
//
//            /*설명. 예외 메시지와 발생한 문자들을 추적 가능하도록 빨간 글씨의 메세지로 처리되는 방식 -jvm과 똑같다*/
//            e.printStackTrace();                       //이걸로 예외처리한 경우_스택영역을 추적하며 출력(반환형 없고 끝)
//            //예외 처리하며 프로그램을 종료까지 함 -> System.exit(0);으로!
//
//
////            System.exit(0);                    //자바 어플리케이션 즉시 종료되도록 처리 프로그램 종료하라 처리

//        }
//        System.out.println("프로그램 종료");

//        try {
//
//            int num = 10;
//            System.out.println(num / 0);        //수학적 용어로 불능
//        } catch (ArithmeticException e) {
//            System.out.println("잘 좀 나눠");
//            System.out.println(e.getMessage() + "라잖아~");
//        }

//        //다형성 적용되어서 Exception넣어도 상관 없음
//        try {
//
//            int num = 10;
//            System.out.println(num / 0);        //수학적 용어로 불능ㅎ
//        } catch (Exception e) {
//            System.out.println("잘 좀 나눠");
//            System.out.println(e.getMessage() + "라잖아~");
//        }
//        System.out.println("프로그램을 종료합니다.");
//        }

}
}
