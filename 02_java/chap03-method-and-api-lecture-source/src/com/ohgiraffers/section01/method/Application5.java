package com.ohgiraffers.section01.method;

public class Application5 {
    public static void main(String[] args) {
        /* 수업목표. 메소드의 리턴에 대해 이해할 수 있다. */

        Application5 app5 = new Application5();
        app5.testMethod();
    }
    public void testMethod() {
         System.out.println("testMethod() 동작 확인 ...");
//    /*설명. 메소드를 호출한 곳으로 돌아가기 위해 return;을 작성(void일 땐 생략 가능)*/
    return;

        // 메소드들도 각 유형이 있음 (대표  void -> 리턴값이 없음, 나머지 대부분은 리턴값이 있음)
    }
}
