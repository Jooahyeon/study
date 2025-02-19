package com.ohgiraffers.chap06.section01.dp;

public class Application3 {

    public static Integer[] dp = new Integer[101];

    public static int solution(int n) {             //Integer 사용하는 이유 : null을 활용하기 위함
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        return padovan(n);
    }

    private static int padovan(int n) {

        /* 설명. 재귀 호출에 의한 stackoverflow를 막기 위해 null이 아닌 값을 만날 때까지만
             재귀호출함(값이 비워져 있으면 점화식으로 채운다) */
        if(dp[n] == null) dp[n] = padovan(n-2) + padovan(n-3);

//        dp[n] = dp[n - 2] + dp[n - 3];                    // 반복안됨..?
//        dp[n] = padovan(n - 2) + padovan(n - 3);          // n 앞 부분의 dp를 채우기 위해 재귀호출, padovan의 반복
        return dp[n];                                       // 재귀호출 멈춤조건 없으면 stackOverflow?발생
    }
}
