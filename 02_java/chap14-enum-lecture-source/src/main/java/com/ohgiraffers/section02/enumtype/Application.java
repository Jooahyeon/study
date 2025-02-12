package com.ohgiraffers.section02.enumtype;

public class Application {
    public static void main(String[] args) {
        Subjects subject1 = Subjects.JAVA;
//        Subjects subject1 = new Subjects();           // 우리가 enum타입의 생성자를 직접사용 X
        Subjects subject2 = Subjects.HTML;
        Subjects subject3 = Subjects.JAVA;

        /*설명.
        *  1. 열거 타입으로 선언된 인스턴스는 싱글톤으로 관리되며 인스턴스가 각각 한 게임을 보장한다.
        *   작성한 순서에 따라 각각은 다른 인스턴스가 생성되며 최초 호출 시에 enum의 생성자를 활용해
        *   생성된다.(lazy singeton 개념)
        * 설명.
        *  2. 단일인스턴스를 보장하기에 == 비교가 가능하다(동일 객체 비교)
        * */

//        if (subject1 == subject2) {         // 서로 다르다라고 뜨는 건 다른 객체기 때문
        if (subject1 == subject3) {         // 서로 같은 객체이기 때문(싱글톤 객체이므로) => 문자비교가 아닌 주소값을 비교하는 것
            System.out.println("두 과목은 같은 과목이다.");
        } else {
            System.out.println("서로 다른 과목이다.");
        }

        /* 설명. 3. 상수 필드명을 문자열로 변경하기 쉽다. 상수클래스 자체의 필드명은 변경되지 않으나 main에서의 필드명이 변경됨,(toString, name)*/
        System.out.println(Subjects.JAVA.toString());           //오버라이딩 가능(재정의 가능)
        System.out.println(Subjects.JAVA.name());               //.name()자체적으로는 바꿀 수 없음.

        /*설명. 4. values()를 이용하면 상수값 배열을 반환받고 이를 활용하여 연속처리해 줄 수 있다.
         *                    (상수필드들에 주입된 객체들을 순회할 수 있다)
        * */

        Subjects[] subjects = Subjects.values();
        for (Subjects sub : subjects) {
            System.out.println(sub.toString());
            System.out.println(sub.ordinal());          // enum에 선언된 상수들의 순서를 인덱스 체계로 추출(순번) /클래스와 배열 짬뽕?
            System.out.println(sub.name());
        }
        /*설명. 5. 타입 안전성을 보장한다. */
        printSubjects(Subjects.JAVA);
//        printSubjects(0);                  //Subjects타입이 아니면 전달할 수 없다.
    }
    // 과목은 6개고 Subject타입으로 쓰겠다 => 제약을 검
    private static void printSubjects(Subjects subjects) {
    }


}
