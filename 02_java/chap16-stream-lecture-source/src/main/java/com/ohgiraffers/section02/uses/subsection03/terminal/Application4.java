package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.Arrays;
import java.util.List;

public class Application4 {
    public static void main(String[] args) {

        /* 수업목표. 스트림의 최종 연산 중 하나인 match 에 대해 이해하고 사용할 수 있다. */
        //요소들의 조건들을 확인하고 싶을 때 사용

        List<String> stringList = Arrays.asList("Java", "Spring", "SpringBoot");

        boolean anyMatch = stringList.stream().anyMatch(str -> str.contains("p"));
        boolean allMatch = stringList.stream().allMatch(str -> str.length()> 4);
        boolean noneMatch = stringList.stream().noneMatch(str -> str.contains("c"));

        System.out.println("anyMatch = " + anyMatch);
        System.out.println("allMatch = " + allMatch);
        System.out.println("noneMatch = " + noneMatch);

//        contains -> String형태를 찾아줌(검색해서 나오면 true, else false
//        anyMatch => 요소들이 하나라도 만족하면 모두 매치해라
//        allMatch => 모든 요소가 만족해야 함
//        noneMatch=> 모든 요소가 매치 x

    }
}
