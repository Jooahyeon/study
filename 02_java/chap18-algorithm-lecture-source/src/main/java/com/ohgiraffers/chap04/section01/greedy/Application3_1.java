package com.ohgiraffers.chap04.section01.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 설명. 람다식을 활용한 풀이 */
public class Application3_1 {
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        int max_count = 0;  //회의가 몇개 열릴 것인지 셈

        // 파싱하는 과정
        BufferedReader br = toBufferedReader(input);
        int N = Integer.parseInt(br.readLine());            // 회의 수
        int[][] time = new int[N][2];                       // 회의 시간 배열 (시작/종료) : 시간은 2차원 배열로 받음

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());  // 시작 시간 (내림차순)을 저장
            time[i][1] = Integer.parseInt(st.nextToken());  // 종료 시간 (오름차순)을 저장
        }

        // compare 형태로 람다식 사용할 것 (int comapre(T o1, T o2))
        // Comparator<T> (내가 쓰려는 인터페이스 타입이 functionalinterface이면 람다식을 쓸 수 있다는 것
       /* 설명. o1/o2는 각각의 회의를 뜻하고 두 개의 회의가 람다식에 넘어온(결과적으로 이차원 배열 안의 1차원 배열 순서가 정렬됨)*/
        Arrays.sort(time, (o1, o2) -> {

           /* 설명. 종료 시간이 같은 회의에 대해서는 */
            if(o1[1] == o2[1]) {                          // 종료시간이 같다면
                return o2[0] - o1[0];                     // 시작시간은 내림차순(순서를 뒤집음)  *1순위
            }

            /* 설명. 종료 시간이 다르다면 다른 회의에 대해서는 */
            return o1[1] - o2[1];                         // 종료시간은 오름차순 *2순위
        });

        int end = 0;
        int same = 0;

        /* 설명. 조건을 만족하는 회의들의 count를 증가시키는 반복문*/
        for (int i = 0; i < N; i++) {
           /* 설명. 최소한 앞선 회의의 끝나는 시간 이후에 열리는 i번째 회의라면*/
            if (end <= time[i][0] && same <= time[i][0]) {

                if (time[i][0] == time[i][1]) {
                    max_count++;
                    same = time[i][1];
                    continue;           // 종료 시간에 영향을 주지 않는다.
                }
                end = time[i][1];       // 진행된 회의의 end 시간으로 업데이트
                max_count++;
            }
        }


        return max_count;

    }
}
