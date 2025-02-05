package com.ohgiraffers.section02.string;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Application3 {
    public static void main(String[] args) {
        /* 수업목표. 1. 문자열 분리에 대해 이해하고 적용할 수 있다. */
        /* 설명.
        *   문자열을 특정 구분자로 분리한 문자열들을 반환하는 기능을 한다.
        *   1. split(): 정규표현식을 이용하여 비정형화된 문자열을 분리한다.
        *               (String을 파싱하여 String[]로 반환해 주고 [](대괄호)를 활용하여 구분자들을 넣어줄 수 있다.)
        *   2. StringTonkenizer: 문자열의 모든 문자들을 구분자를 활용하여 문자열이 분리된다.
        *                       (StringTokenizer가 제공하는 메소드와 while문을 활용하여
        *                        띄어쓰기로 구분된 구분자들을 넣어줄 수 있다.)
        *  파싱 : 예를들어 프론트에서 스트링형으로 받는 것을 백엔드 개발자가 사용자 정의로 구분하여
        *        처리하는 것 그 과정을 파싱이라고 함
        * */

        /*목차. 1. split() 활용 */
        String emp1 = "100/홍길동/서울/영업부";
        String emp2 = "200/유관순//총무부";
        String emp3 = "300/이순신?경기도/";

        String[] empArr1 = emp1.split("/");             //매개변수는 구분자("/")로 활용
        String[] empArr2 = emp2.split("/");
        String[] empArr3 = emp3.split("[/?]");          //구분자 2개 이상인 경우 [] 형태로 사용 (정규표현식으로 받아들임)

        System.out.println(Arrays.toString(empArr1));
        System.out.println(Arrays.toString(empArr2));
        System.out.println(Arrays.toString(empArr3));

        /* 목차. 2. StringTokenizer 활용 */
        // 토큰 : 객체 안에 배열 대신 자체적으로 들고있는 파싱된 데이터단위
        String colors = "red, yellow, green, puple? blue";
        StringTokenizer colorStringTokenizer = new StringTokenizer(colors, ", ? ");
        while (colorStringTokenizer.hasMoreTokens()) {
            /*설명. 현재의 반복 회차 안에서 해당 토큰을 여러번 쓰고 싶으면 변수에 담아 쓰자. */
            String token = colorStringTokenizer.nextToken();
            System.out.println(token);
            System.out.println(token);
            System.out.println(token);
            System.out.println(token);
        }


    }
}
