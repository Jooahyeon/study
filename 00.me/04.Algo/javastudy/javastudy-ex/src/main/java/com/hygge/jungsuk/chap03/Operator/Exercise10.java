package com.hygge.jungsuk.chap03.Operator;

public class Exercise10 {
    public static void main(String[] args) {
        //오답풀이 : 대문자로 변환할 때 ch 문자코드에 32를 증가시켜야 함
    char ch = 'A';                      //대문자인 경우만 소문자로 변경
//    char lowerCase = (ch >= 65 || ch <= 90 ) ? () : ch;
        char lowerCase = ('A' <= ch && ch <= 'Z'? (char)(ch+32) : ch);
    System.out.println("ch:"+ch);
    System.out.println("ch to lowerCase:"+lowerCase);
}

}
