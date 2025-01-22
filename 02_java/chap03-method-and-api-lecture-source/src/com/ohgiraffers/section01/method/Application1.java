package com.ohgiraffers.section01.method;

public class Application1 {
    public static void main(String[] args) {
        //    static(자바가 인식하는 것, 자바가 보인다,메모리에 올라단가)
        //    void(반환값이 없다) -> 출구의미:값이 나감
        //    main(메소드)(연산하는 방법)


        /* 수업목표. 메소드의 호출 흐름에 대해 이해할 수 있다.*/

        System.out.println("main() 시작함...");
        methodA();                                              // 메소드 이름() 까지 쓰면 호출 할 수 있음.
        System.out.println("main() 종료함...");
    }

    public static void methodA() {                              // static이라는 표시가 없어서 호출하지 않으면 인지하지 못함
        System.out.println("methodA() 호출됨...");
        methodB();
        System.out.println("methodA() 종료됨...");
    }

    public static void methodB() {                              // 처음은 메소드 헤드만 인식함(메소드바디,,,등 이름이 이씀)
        System.out.println("methodB() 호출됨...");
        System.out.println("methodB() 종료됨...");

        // filo , lifo 처음 들어온 놈이 나중에 나가는 구조 (엘리베이터 먼저 타면 나중에 내려야함/입구가 하나야) 외워라 정처기,.
        // stack 구조 (입구가 하나밖에 없어서 쌓임 (main<-A<-B) 요렇게 쌓임 위에가 나가지 않으면 나갈 수 없음
        // 여기서 static과 stack을 설명한 것
    }

}
