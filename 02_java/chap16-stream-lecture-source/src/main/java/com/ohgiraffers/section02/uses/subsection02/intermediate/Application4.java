package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Application4 {
    public static void main(String[] args) {
        /* 수업목표. 스트림의 중계 연산 중 하나인 flatMap에 대해 이해하고 사용할 수 있다 */
        List<List<String>> list = Arrays.asList(
                                                Arrays.asList("JAVA", "SPRING", "SPRINGBOOT"),
                                                Arrays.asList("java", "spring", "springboot")
                                                );
        list.stream().forEach(System.out::println);
        System.out.println("list = " + list);

        //map안에 map -> depth가 깊은 형태 (문제점 1. 복사할 때 문제)
        //flatMap 평평하게 나열된 형태로 바꾸어 list형태로 나오도록 함
        // 데이터를 가져올 때 어글리뭐시기?(리스트안에 맵 안에 리스트 안에 맵..)를 뷰티 뭐시기로 바꿔보려면 사용
        List<String> flatList = list.stream().flatMap(Collection::stream)
                .collect(Collectors.toList());
        flatList.stream().forEach(System.out::println);
        System.out.println("flatList = " + flatList);
    }
}
