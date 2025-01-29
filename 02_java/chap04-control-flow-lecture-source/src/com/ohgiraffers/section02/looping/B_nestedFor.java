package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class B_nestedFor {
    public void printGugudanFromTwoToNine() {

        // 2차원을 이중 for문으로 만들어 본 것
        // 3중for문 => 보통 시계 만들 때 사용
        /* 설명.
         *  2단
         *   2 * 1 = 2
         *   2 * 2 = 4
         *   ...
         *  9단
         *   9 * 1 = 9
         *   9 * 2 = 18
         *   ...
         *   9 * 9 = 81
         *
         *   (중첩반복문 => 반복문 안에 반복문, 2차원으로 생각)
        * */

//        for (int dan = 2; dan <= 9 ; dan++) {                              //row (행)
//            System.out.println(dan + "단");
//            for (int su = 1; su <= 9; su++) {                           //clomn(열)
//                System.out.println(dan + " * " + su + " = " + (dan * su));
//            }
//            System.out.println();
//        }

        for (int dan = 2; dan <= 9 ; dan++) {                              //row (행)
            System.out.println(dan + "단");
            printGugudanOf(dan);
            System.out.println();
        }

    }
    //extract를 통해 메소드로 빼냄
    /*설명. dan을 넘겨주면 해당 단수의 구구단을 출력하는 메소드 */

    private static void printGugudanOf(int dan) {
        for (int su = 1; su <= 9; su++) {                           //clomn(열)
            System.out.println(dan + " * " + su + " = " + (dan * su));
        }
    }


    /* 설명.
     *  아래와 같은 별모양이 나오도록 작성해보자.
     *  정수를 입력하시오 : 5
     *          * 0
     *        * *
     *      * * *
     *    * * * *
     *  * * * * *
     * */

    public void printStars() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하시오: ");
        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {

            /* 설명. 공백 찍기 */
            printSpace(input, i);

            /* 설명. 별 찍기 */
            printStars(i);
            System.out.println();

            // 기능이 너무 많고 복잡한 경우 가독성을 위해 메소드로 만들자
            // 매개변수는 가독성이 좋은 이름을 지어주자
            // shift + f6 => 이름 같이 바꾸는 것
        }
    }

    private static void printStars(int row) {
        for (int j = 0; j < (row + 1); j++) {
            System.out.print("*");
        }
    }

    private static void printSpace(int input, int row) {
        for (int j = 0; j < input - (row + 1); j++) {
            System.out.print(" ");
        }
    }


}
