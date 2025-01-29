package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class D_switch {
    public static void testSimpleSwitchStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.println("등급을 입력하세요(G, S, B): ");
        char grade = sc.next().charAt(0);
//        System.out.println("grade = " + grade);

        int point = 0;

        /*설명. true/false 상황을 저장해서 나중에 활용할 용도로 flag 변수를 추가할 수 있다. */
        boolean flag = true;                        // flag -> 맞냐 아니냐 따지는 변수
        switch (grade) {
            case 'G': point += 10;
            case 'S': point += 10;
            case 'B': point += 10;
                     break;
            default:                            // 예외값
                flag = false;
                System.out.println("입력 제대로 하세요.");
        }

        /*설명. if를 활용한 조건문에서 실행 구문이 하나라면 중괄호({}) 생략가능 */
        if(flag == true) {
            System.out.println("당신의 등급은 " + grade + "이고, 현재 포인트는 " + point + "입니다.");
        } else {
            System.out.println("등급도 모르는 것 같은데 이참에 회원가입 합시다.");
        }

    }
}
