package com.ohgirafferse.section05.prameter;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        /* 수업목표. 메소드의 파라미터(매개변수)에 대해 이해하고 사용할 수 있다. */
        PrameterTest pt = new PrameterTest();

        /* 목차. 1. 기본자료형을 매개변수로 전달 받는 메소드 호출 */
        /* 설명. 리터럴 값(참조 주소값X)을 전달해서 메소드를 호출 시에는 서로 다른 지역변수로 서로 영향 X */
        int num = 20;
        System.out.println("call by value 전: " + num);
        pt.testPrimitiveTypeParameter(num);
        System.out.println("call by vlaue 후: " + num);

        /* 목차. 2. 기본자료형 배열을 매개변수로 전달받는 메소드 호출 */
        /* 설명. 참조 주소값을 전달해서 메소드를 호출 시에는 서로 영향 O (feat. 반환할 필요가 없다) */
        //M. 반환하지 않음. 얕은 복사가 일어남 => main의  int[] iArr과 test클래스의 int[] iArr 은 같은 것을 가르킴
        //QA 기본자료형 배열에는 항상 call by reference인가? no
        int[] iArr = new int[]{1, 2, 3, 4, 5};
        System.out.println("call by reference 전: " + Arrays.toString(iArr));
        pt.testPrimtiveArrayTypeParameter(iArr);
        System.out.println("call by reference 후: " + Arrays.toString(iArr));

        /* 목차. 3. 클래스 자료형을 매개변수로 전달 받는 메소드 호출 */
        Rectangle r = new Rectangle(22, 12);
//        r.calArea();
//        r.calRound();
        pt.testClassTypeParameter(r);

        /* 목차. 4. 객체 배열은 배우지 않았으므로 뒤에서 다시 나올 예정 */
        /* 목차. 5. 가변인자를 매개변수로 전달 받는 메소드 호출(자바는 웬만하면 사용을 권징하지 X) */
        pt.testVariableLengthArrayPrameter();
        pt.testVariableLengthArrayPrameter("홍길동");
        pt.testVariableLengthArrayPrameter("김원봉", "축구");
        pt.testVariableLengthArrayPrameter(new String[] {"강감찬", "낚시", "독서"});




    }
}
