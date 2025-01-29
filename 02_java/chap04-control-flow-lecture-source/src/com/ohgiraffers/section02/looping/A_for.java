package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class A_for {
    public void testSimpleForStatement() {

//        동안(1부터; 10까지; 1씩증가) {
//            1부터 10까지 반복하며 출력
//        }
        for (int i=1 ; i<=10; i++) {                                 //디버그모드는 shift+f9
            System.out.println(i + " 출력");
        }
    }

    public void testForExample() {
        /*설명. 각 변수들에 담겨있는 값들에 2를 곱하고 1을 더하여 sum에 누적하자. */
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int num4 = 4;
        int num5 = 5;

        int sum = 0;

        sum += num1 * 2 + 1;
        sum += num2 * 2 + 1;
        sum += num3 * 2 + 1;
        sum += num4 * 2 + 1;
        sum += num5 * 2 + 1;

        System.out.println("sum = " + sum);

        /*설명. for문을 통해 개선해보자 (∴규칙적이며 반복적이 코드들) */
        int forsum = 0;

//        for (int i = 0; i < 5; i++) {
//            forsum += (i + 1) * 2 + 1;
//        }

        for (int i = 1; i < 6; i++) {
            forsum += i * 2 + 1;
        }

        System.out.println("forsum = " + forsum);
    }

    public void testForExample2() {
        /*설명. 입력한 횟수만큼 반복 */
        Scanner sc = new Scanner(System.in);
        System.out.println("limit 값 입력: ");
        int limit = sc.nextInt();

        int sum = 0;

        for (int i = 1; i <= limit; i++) {                      // 조건문이 없으면 무한루프가 생김 나갈 수 없음.
            sum += i;
        }
        System.out.println("sum = " + sum);
    }
}




