package com.ohgiraffers.section01.generics;


/*설명. Object형을 활용해 구현의 편리성은 있지만 타입 안전성은 보장되지 않는다. */
public class MyGenericTest {
    //object타입
    private Object value; //모든걸 받아내고 반환할 수 있음(일반적)

    public MyGenericTest() {

    }
    public Object getValue() {
        return value;
    }

    public void setValue(Object value){
        this.value = value;
    }
}
