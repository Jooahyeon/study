package com.ohgiraffers.section01.literal;

public class Application1 {
    public static void main(String[] args) {

        // 한 줄 주석 -> 코드 설명_강사님용도
        /*
        * 범위주석 -> 개념 설명_강사님용도
        * 여기도 주석
        * 아래도 주석
        *
        * 보통 주석은 맨 위에 한칸 띄고 쓴당
        * */

        /* todo. */
        /* 수업목표 : 여러가지 값의 형태를 출력할 수 있다.*/
        /* 목차 1. 숫차 형태의 값*/
        /* 목차 1-1. 정수 형태의 값 출력 */
        System.out.println(123);

        /* 목차. 1-2. 실수 형태의 값 출력*/
        System.out.println(1.234);

        /* 목차. 2. 문자 형태의 값 출력*/
        System.out.println('a');
        System.out.println('1');
        System.out.println('\u0000');  //값이 없는 문자

        /* 목차. 3. 문자열 형태의 값 출력*/
        System.out.println("안녕하세요");
        System.out.println("a");
        System.out.println("");

        /*목차. 4. 논리 형태의 값 출력*/
        System.out.println(true);
        System.out.println("true"); // 이건 문자열임(논리형X)
        System.out.println(false);


    }
}
