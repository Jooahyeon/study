package com.ohgiraffers.section01.array;

import java.util.Arrays;

public class Application3 {
    public static void main(String[] args) {
        /* 수업목표. 배열에 초기화 되는 자료형별 기본값을 이해할 수 있다. */
        /* 설명
        *   값의 형태별 기본값
        *   정수 : 0
        *   실수 : 0.0
        *   논리 : false
        *   문자 : \u0000
        *   참조 : null
        *   ex. String[] sArr = new String [5] null 값이 5개 들어있음
        * */

        /* 설명. 선언과 동시에 크기 할당 및 초기화까지 한 번에 진행하고 싶을 때 */
        int[] iArr = {10, 11, 12, 13, 14, 15};
        int[] iArr2 = new int[] {10, 11, 12, 13, 14, 15};               // new int[] 생략 가능하나 알아두자

        /* 설명. new int[]을 생략하면 안되는 경우 */
//        test({10, 11, 12, 13, 14});                                     // 에러발생
//        test(new int[] {10, 11, 12, 13, 14});                           // test(배열의 쪽지) 즉, 주소값을 가진 것

        // 노션에 자바의 특징 or 특이한 점 기록해두기 따로!

        /*설명. 1. 단순 for문 */
        for (int i = 0; i < iArr.length; i++) {
            System.out.println(iArr[i]);
        }
        System.out.println();
        /*설명. 2. 향상된 for 문(foreach문) = 받아낼 변수를 활용해 처음부터 끝까지 순회하고자 할 때 쓸 수 있다. (초기값부터 끝까지 돌려줌)*/
        for(int num : iArr) {
            System.out.println(num);
        }

        /*설명. 3.배열의 값들을 단순 확인 */
//        System.out.println(Arrays.toString());

    }

    public static void test(int[] arr) { //배열의 주소값(가리키는 것! 저기로 가!)을 (전달인자로) 받을 수 있는 매개변수
    }

}
