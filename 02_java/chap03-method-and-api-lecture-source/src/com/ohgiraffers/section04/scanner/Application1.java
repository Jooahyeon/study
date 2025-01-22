package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. java.util.Scanner를 이용해 다양한 자료형의 값 입력 받기 */
        Scanner sc = new Scanner(System.in);

        /* 설명. 0. next()를 활용한 문자열 입력 (next()는 띄어쓰기나 엔터가 인지되지 않음=> buffer에 남아있다)(조심해야해!) */
        System.out.print("소속을 입력하세요: ");
        String className1 = sc.next();
        String className2 = sc.next();
        System.out.println("className1: " + className1);
        System.out.println("className2: " + className2);

        sc.nextLine();          //buffer에 있는 엔터 제거용, 자바에서는 띄어쓰기 단위로 토큰 생성


        /* 설명. 1. nextLine()을 활용한 콘솔(console)에서의 문자열 입력 */
        // 콘솔 : 출력이 나오는 곳
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.println("name = " + name);

        /* 설명. 2. nextInt()를 활용한 정수 입력 */
        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();
        System.out.println("age = " + age);

        /*설명. 3. nextDouble()을 활용한 실수 입력 */
        System.out.print("키를 입력하세요: ");
        double height = sc.nextDouble();
        System.out.println("height = " + height);




    }
}
