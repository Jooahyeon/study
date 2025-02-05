package com.ohgiraffers.section04.wrapper;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. Wrapper클래스에 대해 이해할 수 있다. */
        int intValue = 20;


        /* 설명. 기본자료형을 Wrapper클래스 자료형으로 변환할 수 있다(박싱, boxing) */
        Integer autoBoxingInt = 20;                                 // 오토 박싱(auto - boxing)
        Integer boxingInt2 = Integer.valueOf(intValue);        // 정석


        /* 설명. Wrapper 클래스 자료형을 기본자료형으로 변환할 수 있다(언박싱, unboxing) */
        int autoUnboxingInt = autoBoxingInt;                    //오토언박싱(auto-unboxing)
        int unboxingInt2 = boxingInt2.intValue();

        anythingMethod(20);

        /* 설명. Wrapper 클래스 주소값 비교 */
        //constantpool 을 써서 동등한 객체인 경우 주소값을 하나만 나오게 함.

        Integer integerTest = 30;
        Integer integerTest2 = 30;
        System.out.println("==비교: " + (integerTest == integerTest2));
        System.out.println("equals() 비교: " + integerTest.equals(integerTest2));
        System.out.println("integerTest주소: " + System.identityHashCode(integerTest));

        /* 설명. 모든 Wrapper 클래스도 constant pool을 활용해 동등 객체는 하나만 (동일 인스턴스로) 저장한다.*/
        System.out.println("integerTest2주소: " + System.identityHashCode(integerTest2));
    }

    private static void anythingMethod(Object obj) {        //오토박싱과 다형성이 일어나서 대입이 됨.

        /* 설명. int -> Integer(오토박싱) -> Object(다형성) */
        /* 설명. 출력 -> Object의 toString()에서 Integer의 toString()(동적바인딩)이 실행 됨.*/
        System.out.println("obj: " + obj);
//        System.out.println("obj: " + ((String)obj));


    }

}
