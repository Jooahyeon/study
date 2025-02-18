package com.hygge.jungsuk.chap04;

public class Exercise13 {
    public static void main(String[] args)
    //지피티티티티
    {
        String value = "12o34";
        char ch = ' ';
        boolean isNumber = true;

        for(int i = 0; i < value.length(); i++) {
            ch = value.charAt(i);
            if(!('0'<=ch && ch<='9')) {
                isNumber = false;
                break;
            }
        }
        if (isNumber) {
            System.out.println(value+" .");
        } else {
            System.out.println(value+" .");
        }
    } // end of main
}
