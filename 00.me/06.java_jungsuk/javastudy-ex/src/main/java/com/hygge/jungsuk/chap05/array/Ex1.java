package com.hygge.jungsuk.chap05.array;

public class Ex1 {
    public static void main(String[] args) {
        /* 문제. 다음은 배열을 선언하거나 초기화한 것이다 잘못된 것을 고르고 그 이유를 설명하시오.*/

       /*
        a.int[] arr[];
        => X (int[][] arr 형태로 선언해야 함)

        b.int[] arr = {1,2,3};
        => O (배열 선언과 동시에 초기화)

        c.int[] arr = new int[5];
        => O (배열 선언 및 공간 할당)

        d.int[] arr = new int [5] {1,2,3,4,5};
         => X (크기지정)

        e.int arr[5];
         => X

        f.int[] arr[] = new int[3][];
         => X (배열은 []붙여서 써야함)

        */
        int[] arr = new int[]{1,2,3,4,5};




    }


}
