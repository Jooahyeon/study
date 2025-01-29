package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

// Elif -> if else if

public class C_ifElseIf {
    public void testSimpleIfElseIfStatement() {
        System.out.println("산 속에서 나무를 하면 나무꾼이 연못에 도끼를 빠뜨리고 말았다.");
        System.out.println("연못에서 산신령이 나타나 금도끼, 은도끼, 쇠도끼를 들고 나타났다.");
        System.out.println("나무꾼에게 셋 중 어떤 도끼가 나무꾼의 도끼인지 물어보았다.");

        System.out.print("어느 도끼가 너의 도끼이냐? (1. 금도끼, 2. 은도끼, 3. 쇠도끼): ");

        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();

        if(answer == 1) {
            System.out.println("이런 거짓말쟁이!! 너에게는 아무런 도끼도 줄 수 없구나!! 이 욕심쟁이야!!");
        } else if(answer == 2) {                                                                //else = 예외처리 중 하나
            System.out.println("욕심이 과하지는 않지만 그래도 넌 거짓말을 하고 있구나!! 썩 꺼지거라!!");
        } else {
            System.out.println("오호~ 정직하구나~ 여기 있는 금도끼, 은도끼, 쇠도끼를 다 가져가거라!!");
        }

        System.out.println("그렇게 산신령은 다시 연못 속으로 홀연히 사라지고 말았다...");
    }

    public void testNestedIfElseIfStatement() {
        // 코드는 순자척으로 흐르기 때문 (위에서부터)
        Scanner sc = new Scanner(System.in);

        System.out.println("이름을 입력하세요");
        String name = sc.nextLine();

        System.out.println("점수를 입력하세요.");
        int score = sc.nextInt();                       // 점수 score
        String grade;                               // 자바도 에러 가능, 초기값을 넣어주자 String grade = "";

        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        if (score < 0 || score > 100 ) {
            System.out.println("점수를 잘못 입력하셨습니다.");
        } else {
            if (score % 10 >= 5 && score >= 60 || score == 100) {
                grade = grade + "+";
            }
            System.out.println(name + "학생의 점수는 " + score + "점이고 " + "등급은 " + grade + "입니다"  );
        }

        sc.close();

        System.out.println("프로그램을 종료합니다.");

    }
}
