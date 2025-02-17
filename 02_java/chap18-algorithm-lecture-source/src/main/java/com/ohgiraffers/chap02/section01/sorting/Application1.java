package com.ohgiraffers.chap02.section01.sorting;

/* 수업목표. 버블 정렬을 이해할 수 있다. */
/* 설명.
*   정렬 알고리즘
*   데이터를 특정 순섣로 배열하는데 사용한다.(일반적으로는 배열의 정렬을 뜻함)
*
*  설명.
*   버블 정렬(Bouble Sort)
*   두 인접한 데이터의 크기를 비교해 정렬하는 방법이다.
*   버블의 모든 요소에 대해 반복하면서, 각 반복마다 가장 큰(작은) 요소가 배열의 끝으로
*   "버블링(이동)" 된다.
*   시간 복잡도는 O(n^2)이라 효율적이지는 않다.
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Application1 {
    /* 설명.
     *  문제 내용
     *   : N개의 정수가 주어졌을 때, 버블 정렬 알고리즘을 사용하여 오름차순으로 정렬하는 프로그램을 작성하시오.
     *  입력
     *   - 첫 번째 줄에 자연수 N(1 <= N <= 100)이 주어진다.
     *   - 두 번째 줄에 N개의 정수가 공백으로 구분되어 입력된다. 각 정수는 -10^9 이상, 10^9(10억까지) 이하이다.
     *  출력
     *   - 오름차순으로 정렬된 수열을 공백으로 구분하여 출력한다.
     *
     *  설명.
     *   예시 입력 1
     *     - 7                                  => 파싱이 필요한 작업
     *       34 23 5 24 1 9 12
     *   예시 출력 1
     *     - 1 5 9 12 23 24 34
     *
     *  설명.
     *   예시 입력 2
     *     - 6
     *       40 47 38 8 33 35
     *   예시 출력 2
     *     - 8 33 35 38 40 47
     * */

    /* 설명. 입력 데이터 받기 */
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);         // 정규표현식으로 비교하여 시간이 오래 걸림 -> BufferedReader가 더 빠름
//        int length = sc.nextInt();                   // 입력 받을 크기
//        int[] arr = new int[length];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = sc.nextInt();                   //공백, 엔터 전까지 파싱해 문자열 -> int형으로 변환 작업까ㅏ지 완료
//        }

        // t-w-c구문? finally를 작성하지 않아도 됨(try()안에 버퍼넣어)
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(br.readLine());                                         //valueOf()비효율 왜?

            /* 설명. 1. split 활용*/
//            String[] strArr = br.readLine().split("");
//            int[] arr = new int[length];
//            for (int i = 0; i < strArr.length; i++) {
//                arr[i] = Integer.parseInt(strArr[i]);
//            }

            /* 설명. 2. StringTokenizer 활용 */
//            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//            int[] arr = new int[st.countTokens()];                                   //countTokens 토큰의 갯수를 셈
//            int index = 0;
//            while (st.hasMoreTokens()) {                            //hasMoreTokens 추가적인 토큰이 남아있는지 확인
//                arr[index] = Integer.parseInt(st.nextToken());
//                index++;
//            }

            /* 설명. 3. Stream 활용*/
            IntStream intStream = Arrays.stream(br.readLine().split(""))
                                          .mapToInt(x -> Integer.parseInt(x));   //mapToInt(IntSting으로 바꿔줌)
            int[] arr = intStream.toArray();

            solution(length, arr);
            //call by reference로 반환값 없어도 됨. 아래와 같은 값(arr)이라서


            System.out.println("length = " + length);
            System.out.println("arr = " + Arrays.toString(arr));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /* 설명. 넘어온 데이터를 가지고 버블 정렬 알고리즘 작성 시작 (놓침 깃보고 작성해라)*/
    public static void solution(int length, int[] arr) {                   //위와 같음 (call by reference)
        // 버블정렬 -> 오름차순 내림차순을 먼저 정함
        for (int i = 0; i < length; i++) {
            System.out.println((i+1) + "번째 순회" + Arrays.toString(arr));
            for (int j = 0; j < length - 1; j++) {
                if (arr[j] > arr[j + 1]) {          // 오름차순            // j가 j+1보다 크면 둘의 위치를 바꿔줌
//                  if(arr[j] < arr[j + 1] ){       // 내림차순
                   /* 설명. j번째와 그 다음인 (j+1)번째의 위치를 서로 바꿈(swqp) */
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }
}
