package com.ohgiraffers.section01.generics;
/*설명.
*  제네릭 클래스의 다이아몬드 연산자(<>)에 들어갈 수 있는 4가지 타입 (의미부여상)
*   1. E : Element
*   2. T : Type(일반적으로 사용)
*   3. K : Key
*   4. V : Value
* */


public class GenericTest<T> {
    //제네릭활용
    //객체 생성 시 타입 지정
    private T value;
    private String value2;

    public GenericTest() {

    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
