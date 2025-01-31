package com.ohgiraffers.section2.variable;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 변수의 사용 목적에 대해 이해할 수 있다.*/
        /* 목차. 1. 값에 의미를 부여하기 위한 목적 (가독성 위해) */
        System.out.println("===== 값에 의미 부여 테스트 =====");
        System.out.println("보너스를 포함한 급여: " + (1000000 + 200000) + "원");

        // 변수명을 짓는 것은 고민해서 짓자
        // ctrl + d 해당 줄의 코드를 한 줄 복사
        // shift + alt (해당 코드를 상하 코드로 움직일 수 있음)

        int salary = 1000000;
        int bonus = 20000;

        System.out.println("보너스를 포함한 급여: " + (salary + bonus) + "원");

        /* 목차. 2. 한 번 저장해둔 값을 재사용하기 위한 목적 (재사용 -> 유지보수성의 도움을 받기 위함)*/
        System.out.println("===== 1번 고객에게 포인트를 100포인트 지급하였습니다. =====");
        System.out.println("===== 2번 고객에게 포인트를 100포인트 지급하였습니다. =====");
        System.out.println("===== 3번 고객에게 포인트를 100포인트 지급하였습니다. =====");
        System.out.println("===== 4번 고객에게 포인트를 100포인트 지급하였습니다. =====");
        System.out.println("===== 5번 고객에게 포인트를 100포인트 지급하였습니다. =====");
        System.out.println("===== 6번 고객에게 포인트를 100포인트 지급하였습니다. =====");
        System.out.println("===== 7번 고객에게 포인트를 100포인트 지급하였습니다. =====");
        System.out.println("===== 8번 고객에게 포인트를 100포인트 지급하였습니다. =====");
        System.out.println("===== 9번 고객에게 포인트를 100포인트 지급하였습니다. =====");
        System.out.println("===== 10번 고객에게 포인트를 100포인트 지급하였습니다. =====");

        System.out.println();       // 공백 한 줄 추가

        //한 줄 주석 단축키 Ctrl + /
        // int point = 100;
        int point = 200;            // 쉽게 포인트 수정 가능(재사용을 통한 유지보수 향상)
        System.out.println("1번 고객 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("2번 고객 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("3번 고객 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("4번 고객 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("5번 고객 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("6번 고객 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("7번 고객 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("8번 고객 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("9번 고객 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("10번 고객 포인트를 " + point + "포인트 지급하였습니다.");

        /* 목차. 3. 시간에 따라(코드 흐름에 따라) 변경되는 값을 같은 이름으로 사용 할 목적 */
        System.out.println("===== 변수에 저장된 값 변경 테스트 =====");
        int sum = 0;        //sum 에 10이 담김
        //빨간 점 브레이크 포인트 (실행되지 않는 코드,,실행이 멈춘,,거..찾아주는..)
        //벌레 -> 디버그모드 (f8)
        sum = sum + 10;
        System.out.println("sum에 10을 더하면 sum의 값은 : " + sum);

        sum = sum + 10;
        sum = sum + 10;
        sum = sum + 10;
        sum = sum + 10;
        System.out.println("sum에 10을 네 번 더 누적하면 sum의 값은: " + sum);

    }
}
