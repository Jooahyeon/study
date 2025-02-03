package com.ohgirafferse.section06.statickeyword;

public class StaticTest {

    // static을 공유의 목적으로 사용
    private int nonStaticCount;
    private static int staticCount;

    public StaticTest() {

    }

    public int getNonStaticCount() {
        return nonStaticCount;
    }

    public static int getStaticCount() {
        return staticCount;
    }

    public void increaseNonstaticCount() {
        this.nonStaticCount++;
    }

    public void increaseStaticCount() {
        StaticTest.staticCount++;
    }
}
