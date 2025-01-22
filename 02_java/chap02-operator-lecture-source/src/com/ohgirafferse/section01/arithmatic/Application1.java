package com.ohgirafferse.section01.arithmatic;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 수업목표. 산술연산자에 대해 이해하고 활용할 수 있다.*/
        int num1 = 20;
        int num2 = 7;

        System.out.println("num1 + num2 = " + (num1 + num2));
        System.out.println("num1 - num2 = " + (num1 - num2));
        System.out.println("num1 * num2 = " + (num1 * num2));

        double testNum = num1 / (double)num2;
        double transNum = (int)(testNum * 100) / (double)100;       //의도적으로 버림을 한 것 (예시)
        System.out.println("testNum = " + testNum);
        System.out.println("transNum = " + transNum);

        System.out.println("num1 % num2 = " + (num1 % num2));       // % -> mod, modulus연산자라고 읽음

    }
}
