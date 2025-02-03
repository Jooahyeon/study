package com.ohgirafferse.section05.prameter;

import java.util.Arrays;

public class PrameterTest {
    public void testPrimitiveTypeParameter(int num) {
        num = 10;
        System.out.println("매개변수로 전달받아 수정한 값: " + num);
    }

    public void testPrimtiveArrayTypeParameter(int[] iArr) {
        iArr[0] = 100;
    }

    public void testClassTypeParameter(Rectangle rectangle) {
        rectangle.calArea();
        rectangle.calRound();
    }
    /*설명. 가변인자는 넘어온 인자들을 받아내어 배열로 바꿔준다. */
    public void testVariableLengthArrayPrameter(String... str) { //(String...) = 가변인자
        System.out.println("넘어온 인자들 출력: " + Arrays.toString(str));
    }
}
