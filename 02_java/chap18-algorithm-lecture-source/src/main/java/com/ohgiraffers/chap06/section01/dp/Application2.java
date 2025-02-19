package com.ohgiraffers.chap06.section01.dp;

public class Application2 {
    public static int solution(int n) {
        int[] dp = new int[1000 + 1];
        if(n >= 1) dp[1] = 1;
        if(n >= 2) dp[2] = 2;

        if(n >= 3) {
            /* 설명. n이 3부터 점화식이 적용됨 */
            for (int i = 3; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }
}
