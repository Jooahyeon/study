package com.ohgiraffers.chap01.section01.timecomplexity;

import java.sql.SQLOutput;
import java.util.Arrays;



public class Application {
    /* 수업목표. 시간복잡도를 이해할 수 있다. */
    /* 설명. 알고리즘 실행 시 입력 값이 증가함에 따라 연산이 걸리는 시간의 증가도를 나타낸다 */

    public static void main(String[] args) {

        int[] arr = new int[]{3, 1, 2, 15, 4, 9, 10, 7};
//        System.out.println(getFirst(arr));
//        System.out.println(binarySearch(arr, 9));
//        System.out.println(Arrays.toString(reversed(arr)));
    }

    /* 설명. 상수 시간 0 (1) */
    /* 설명.
     *   입력값의 크기와 상관 없이 항상 일정한 시간이 걸리는 알고리즘이다.
     *   (1번 돌리든 2번 돌리든 걸리는 시간은 동일함?) */

    private static int getFirst(int[] arr) {
        return arr[2];
    }

    /* 설명. 로그 시간 0 (log n) */

    /* 설명.
     *   입력값이 증가함에 따라 처리 시간이 로그만큼 증가하는 알고리즘이다.
     *   이진 탐색(대표적임)은 매 단계마다 탐색 범위를 절반으로 줄이므로 매우 효율적이며
     *   O(log n)에 해당한다.
     *   단, 정렬이 선행되어야 한다 (조건) _ sort
     * */
    private static int binarySearch(int[] arr, int target) {
//
//        /* 설명. 초기 세팅(배열을 오름차순 정렬하고 시작) */
        Arrays.sort(arr);                   // 퀵 정렬로 nlogn 시간만큼 소요된다(지금 고려사항 아님)
//
//        /* 설명. 배열의 처음과 끝을 지칭하는 위치(인덱스)를 담은 변수 두개(두 개의 포인터) */

        int left = 0;
        int right = arr.length - 1;
//
//        int left = 0, right = arr.length - 1;                //같은 자료형이라 한줄로 작성 가능
//        while (left <= right) {
//            int mid = left + (right - left) / 2;            //짝수개는 절반의 하나 앞이 중간(mid)이다.
//            if (arr[mid] == target) {
//                return mid;
//            } else if (arr[mid] < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//
//
//        }
//
//        return -1;  // target이 없을 때
//    }

        /* 설명. 선형시간 O(n) -> 시간복잡도에서 상수 연산은 다 제외함 */
        /* 설명.
         *   입력값이 증가함에 따라 처리 시간이 선형적으로 증가하는 알고리즘이다.
         *   배열의 모든 요소를 한 번씩 순회해야 하므로 배열의 크기에 비혜하는 시간이 필요하다.
         * */
//    private static int[] reverse(int[] arr) {
//        int[] reversed = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            reversed[arr.length - i - 1] = arr[i];
//
//        }
//        return reversed;
//    }

        /* 설명. 지수 시간 O(2^n) */
        /* 설명.
         *   입력값이 증감함에 따라 시간이 기하급수적으로 증가하는 알고리즘
         *   재귀적으로 두 번씩 자신을 호출하므로 매우 비효율적인 시간복잡도를 가진다.
         * */
        // 재귀호출 -> 자기 자신을 호출
//    private static int fibonacci(int n) {
//        if (n <= 1) return n;
//        return fibonacci(n - 1) + fibonacci(n - 2);
//    }
        return left;
    }
}