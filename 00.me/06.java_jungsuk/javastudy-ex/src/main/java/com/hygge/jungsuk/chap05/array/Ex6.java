package com.hygge.jungsuk.chap05.array;

public class Ex6 {
    public static void main(String[] args) {
        int[] coinUnit = {500, 100, 50, 10};
        int money = 2680;

        System.out.println("money=" + money);

        for (int i = 0; i < coinUnit.length ; i++) {
            coinUnit[0] = money / 500;
            coinUnit[1] = (money % 500) / 100;
            coinUnit[2] = ((money % 500) % 100) / 50;
            coinUnit[3] = (((money % 500) % 100) % 50) / 10;
        }
        System.out.println("500원: " + coinUnit[0]);
        System.out.println("100원: " + coinUnit[1]);
        System.out.println("50원: " + coinUnit[2]);
        System.out.println("10원: " + coinUnit[3]);
    }

}
