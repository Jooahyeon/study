package com.ohgiraffers.section01.array;

import java.util.Arrays;

public class Application1  {
    public static void main(String[] args) {
        /* 수업목표. 배열에 대해 이해하고 배열의 사용 목적을 이해할 수 있다. */
        // 하나의 이름으로 반복문 할 시 한줄코딩 가눙?
        int num1 = 10;
        int num2 = 20;
        int num3 = 30;
        int num4 = 40;
        int num5 = 50;

        int sum = 0;

        sum += num1;
        sum += num2;
        sum += num3;
        sum += num4;
        sum += num5;

        System.out.println("sum = " + sum);

        int[] arr = new int[5];                    //자바는 크기(몇개를 넣을건지) 지정해줘야 함
        // (int의 기본값인 0이 존재) [0][0][0][0][0]
        System.out.println("arr = " + arr);
        // [=?  @ = at, I = int, 뒤 나머지는 16진수 (주소값이 들어있음) -> 콘솔창에 주소값 나옴
        // 기본자료형이 아닌 친구들은 모두 toString()을 가지고 있음=> 상속 때 다시 배움
//        System.out.println("arr = " + arr.toString());
        System.out.println("배열의 모습을 보고 싶어: " + Arrays.toString(arr)); // 1차월 배열일 경우만 볼 수 있음.

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;
        //규칙이 보이는 경우 반복문으로 쓸 수 있음. 불규칙한 값에는 반복문 필요 없어!

        /* 설명. 10부터 50까지의 값을 5개의 공간에 담기 */
        for (int i = 0; i < 5; i++) {
            arr[i] = (i +1) * 10;
        }

        /*설명. 반목문을 활용해 간단히 누적하는 작업을 할 수 있다. */
        int arrSum = 0;
        for (int i = 0; i < 5; i++) {
            arrSum += arr[i];
        }

        System.out.println("arrSum = " + arrSum);

        // shift + F6 => rename 단축키







    }
}
