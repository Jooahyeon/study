package com.ohgiraffers.section02.enumtype;

public enum Subjects {
    JAVA,                       //필드명으로 쓰자
    MARIADB,                    // 상수필드이자 참조자료형, 싱글톤 객체들을 담고 있음
    JDBC,
    HTML,
    CSS,
    JAVASCRIPT;         // enum타입 필드가 끝나면 ;(세미콜론)찍자

    Subjects() {
        System.out.println("기본 생성자 실행됨..");                 //총 6개의 객체가 생성되어
        // subject를 생성해야 함 -> lazy싱글톤(호출시 실행됨)          //eager싱글톤(은 static일 때 바로 생성됨)
        // 생성자는 필드의 갯수만큼만 생성됨
        // (즉 객체의 주소가 하나밖에 없어서 main에서 변수명을 다르게 써도 같은 객체로 인식함

    }

    @Override
    public String toString() {
        return "@@@@" + this.name() + "@@@@";           //재정의
    }
}
