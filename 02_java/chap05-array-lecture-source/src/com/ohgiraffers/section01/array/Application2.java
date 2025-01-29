package com.ohgiraffers.section01.array;

import java.util.Arrays;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 배열의 사용방법을 익혀 배열을 사용할 수 있다. */
        /*설명.
        *  배열의 사용방법
        *  1. 배열의 선언                                stack의 영역에 들어간 것(주소값이 담기는 4byte가 stack에 생긴 것)
        *  2. 배열의 크기 할당
        *  3. 배열의 인덱스 공간에 값 대입
        * */

        int[] iArr;                 // 모든 자료형을 쓸 수 있음
        char cArr[];                // []의 위치는 변수명 뒤에 써도 성립하지만 지양할 것.

        iArr = new int[5];          // 0 ~ 4 까지의 인덱스로 각 칸을 구분(인덱스체계)
        cArr = new char[5];

        System.out.println("iArr = " + iArr);
        System.out.println("cArr에 담긴 값: " + Arrays.toString(cArr));    // 유니코드상 0000이 출력됨 \u0000

        System.out.println("cArr의 주소를 10진수 형태로 보고 싶다 : " + cArr.hashCode());
        //hashCode 출력 값(주소값을 10진수로 바꿔준 것) -> 뒤에서는 재정의하여 뜻이 달라지니 알아둘 것

        cArr = null; cArr = new char[5];
        // 참조자료형의 기본 값은 null =>  stack에서 주소가 사라진 것 = heap과의 연결이 끊어진 것
        // 1. 개발자가 힙(heap)의 주소값을 직접 사용할 수 없다(메모리가 비효율적, 등의 문제로 개발자가 만질 수 없게 함)
        // 2. (그럼 안건드리고 효율적이게 어떻게 할건데?) GC (garbage collector) => old 영역으로 넘어가면 GC가 비워줌 (자동으로 효율적으로 처리해줌, 휴먼에러 방지)
        System.out.println("cArr의 값을 비우고(null) 보면: " + cArr.hashCode());
        //point -> 가리킨다. / NullPointException => "."을 찾아가



    }
}
