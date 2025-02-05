package com.ohgiraffers.section04.wrapper;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 문자열을 다양한 기본 자료형으로 바꿀 수 있다. */
        byte b = Byte.valueOf("1");
        short s = Short.valueOf("2");
        int i = Integer.valueOf("4");
        long l = Long.valueOf("8");
        float f = Float.valueOf("4.0");
        double d = Double.valueOf("8.0");
        boolean isTrue = Boolean.valueOf("true");
        char c = "abc".charAt(0);       // Character는 메소드가 제공되지 않아 String의 charAt()을 활용

        // parse 코테할 때는 이게 조금 더 빠르니 이거로 쓰기
        // parse는 처음부터 반환형이 기본자료형이라 auto-unboxing을 거치지 않기 때문이다.
        byte b2 = Byte.parseByte("1");
        short s2 = Short.parseShort("2");
        int i2 = Integer.parseInt("4");
        long l2 = Long.parseLong("8");
        float f2 = Float.parseFloat("4.0");
        double d2 = Double.parseDouble("8.0");
        boolean isTrue2 = Boolean.parseBoolean("true");
        char c2 = "abc".charAt(0);

    }
}
