package com.ohgiraffers.section02.set.run;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {
        /* 수업목표. TreeSet에 대해 이해하고 활용할 수 있다. */
        /* 설명. Tree 구조를 활용해 중복 제거 + 정렬을 해준다.*/
        //이진검색트리구조 (부모가 자식을 두개밖에 안가짐/중간값으로 비교 -> 보통 순회보다 빠름)
        Set<String> tset = new TreeSet<>();
        tset.add("ramen");
        tset.add("pork");
        tset.add("kimchi");
        tset.add("friedEgg");
        tset.add("soup");
        tset.add("soup");
        System.out.println("tSet = " + tset);

        //tip. 노드와 엣지로 구성된 것을 그래프알고리즘이라고 함

        /*설명. 로또 번호 발생기(feat. 보너스 번호 추출 제외)
         *  1부터 45까지 중복되지 않고 오름파순 정렬된 6개의 값 추출하기
         * */

        Set<Integer> lotto = new TreeSet<>();

        while (lotto.size() < 6) {
            lotto.add((int) (Math.random() * 45) + 1);
        }
        System.out.println("lotto = " + lotto);

        /*설명. 배열을 활용한 TreeSet과 같은 기능(정렬은 빼고)을 하는 알고리즘 구현해 보기*/
        /*설명. 1부터 45까지의 난수를 생성해 중복되지 않은 6개의 값을 배열에 저장하기 */
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 45) + 1;

            /*설명. 이전 생성된 값들과 비교*/
//            i = duplicatieValidation(i, arr);
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j])
                    i--;
                break;                      //중복된 값을 찾으면 i-- + 빠져나감
            }
            System.out.println("배열에 담긴 값: " + Arrays.toString(arr));
            //중복제거 (뒤에서 앞의 수를 보고 체크하면서 제거해야 함)


        }
//        return current;
    }
}