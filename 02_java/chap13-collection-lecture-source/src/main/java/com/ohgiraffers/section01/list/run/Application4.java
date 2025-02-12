package com.ohgiraffers.section01.list.run;

import java.util.Stack;

public class Application4 {
    public static void main(String[] args) {
        /* 수업목표. stack에 대해 이해하고 사용할 수 있다. */
        /*설명.
        *  stack이란?
        *   후임선출(LIFO) 또는 선입후출(FILO)의 자료구조로 push(), pop(), peek() 등의 메소드를
        *   활용하여 자료를 처리할 수 있다.
        * */

        /* 설명. stack 객체 생성 후 데이터 추가 */
        Stack<Integer> integerStack = new Stack<>();

        integerStack.push(1);              //오토박싱이 일어난 것이고 인티져의 주소값을 가짐
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        integerStack.push(5);

        System.out.println("integerStack = " + integerStack);

        System.out.println("peek(): " + integerStack.peek());       //마지막에 넣었던게 나옴(꺼낸건 아님!)

        /*설명. Stack은 마지막부터 하나씩 순차적으로 카운팅 한다.(feat. 동등비교가 가능해야한다.(e, h 오버라이딩)) */

        System.out.println("search(): " + integerStack.search(2));
        // 객체는 다르지만 들어있는 값이 2인 놈을 찾아 순차적으로 센 것
        // equals가 안되어 있으면 해쉬값만 비교를 하기 때문에 같은 값을 가지더라도 다른 객체로 구분된다.
        //equals와 hashcode가 오버라이딩 되어 있어 search가 가능한 것임

        System.out.println("pop(): " + integerStack.pop());
        System.out.println("pop(): " + integerStack.pop());
        System.out.println("pop(): " + integerStack.pop());
        System.out.println("pop(): " + integerStack.pop());
        System.out.println("pop(): " + integerStack.pop());
        System.out.println(integerStack);

    }
}
