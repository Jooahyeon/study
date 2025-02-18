package com.hygge.jungsuk.chap03.Operator;

public class Exercise7 {
    public static void main(String[] args) {
        /* 자바 소수점 자릿수 표현
            1. System.out.printf("%. 3f")
            2. String.format()
            3. Math.round
         */
    int fahrenheit = 100;                       //화씨
    float celcius = ((5/9f * ((float)fahrenheit - 32f)));              //섭씨
    System.out.println("Fahrenheit:"+fahrenheit);
    System.out.println("Celcius:"+celcius);
        System.out.printf("%celcius.3f");
}
}
