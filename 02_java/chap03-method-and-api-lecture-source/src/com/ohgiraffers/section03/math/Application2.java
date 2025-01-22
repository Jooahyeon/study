package com.ohgiraffers.section03.math;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 사용자 지정 범위의 난수를 발생시킬 수 있다. */

        /* 설명. 1. 0 ~ 9 까지의 난수 생성 */
        int random1 = (int)(Math.random() * 10);

        /* 설명. 2. 80 ~ 100 까지의 난수 생성 */
        int random2 = (int)(Math.random() * 21) + 80;      //생성할 난수 갯수 *, 초기값 +

        /* 설명. 3. -188 ~ 10 까지의 난수 생성 */
        int random3 = (int)(Math.random() * (188 + 1 + 10)) + (-188);

        System.out.println("random1 = " + random1);
        System.out.println("random2 = " + random2);
        System.out.println("random3 = " + random3);

    }
}
