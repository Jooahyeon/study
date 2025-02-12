package com.ohgiraffers.section01.list.run;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Application5 {
    public static void main(String[] args) {

        /* 수업목표. Queue에 대해 이해하고 활용할 수 있다. */
        /* 설명.
        *   Queue란?
        *   선형 메모리 공간에 데이터를 저장하여 순서를 유지하기 위한 선입선출(FIFO) 방식의 자료구조이다.
        *   대부분 LinkedList를 많이 사용한다.
        * */

//        Queue que = new Queue();    // Queue의 생성자를 활용할 수 없다.(인터페이스는 객체 생성 안되기때문)
                                      //(Queue의 구현체는 하위타입으로 만들어야 한다.)
//        Queue<String> que = new LinkedList<String>();

        /* 설명. priorityQueue를 활용하면 선입선출+정렬의 개념을 가져갈 수 있다.*/
//        Queue<String> que = new PriorityQueue<>();
        Queue<String> que = new PriorityQueue<>(Collections.reverseOrder());


        que.offer("first");
        que.offer("second");
        que.offer("third");
        que.offer("fourth");
        que.offer("fifth");
        System.out.println("que = " + que);

        System.out.println("peek(): " + que.peek());     //peek
        System.out.println("que = " + que);
        System.out.println("poll(): " + que.poll());    //poll 제거 반환
        System.out.println("que = " + que);
        System.out.println("poll(): " + que.poll());
        System.out.println("que = " + que);
        System.out.println("poll(): " + que.poll());
        System.out.println("que = " + que);
        System.out.println("poll(): " + que.poll());
        System.out.println("que = " + que);
        System.out.println("poll(): " + que.poll());


    }
}
