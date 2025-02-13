package com.hygge.jungsuk.chap03.Operator;

public class Exercise9 {
    public static void main(String[] args) {
        char ch = 'z';
        boolean b = (ch >= 'a' && ch <= 'z' )|| (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <='9');
        System.out.println(b);
    }
}
