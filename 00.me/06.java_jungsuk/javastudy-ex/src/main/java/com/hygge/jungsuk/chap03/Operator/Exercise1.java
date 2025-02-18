package com.hygge.jungsuk.chap03.Operator;

public class Exercise1 {
    public static void main(String[] args) {
        int x = 2;
        int y = 5;
        char c = 'A'; // 'A' 65 의 문자코드는
        //'C' = 67
        System.out.println(1 + x << 33);                    // 6
        // 틀림 -> 쉬프트연산자

        System.out.println(y >= 5 || x < 0 && x > 2);       // true
        // true || false = true
        System.out.println(y += 10 - x++);                  // 13
        System.out.println(x+=2);                           // 5
        System.out.println( !('A' <= c && c <='Z') );       // false
        System.out.println('C'-c);                          // 2
        System.out.println('5'-'0');                        // 53-48 = 5
        System.out.println(c+1);                            // 66
        System.out.println(++c);                            // 66('B')
        System.out.println(c++);                            //'B' (+1)
        System.out.println(c);                              // C
    }

}
