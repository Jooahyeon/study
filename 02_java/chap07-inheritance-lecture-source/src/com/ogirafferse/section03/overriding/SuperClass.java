package com.ogirafferse.section03.overriding;

public class SuperClass {

    /* 수업목표. 1. 오버라이딩에 대해 이해할 수 있다. */
    /* 설명. 멤버(필드,메소드)들은 public/protected/default/private 네가지가 있다. */

    public void method(int num) {}

    public Object method2(int num){
        return null;
    }
    private void privateMethod() {}

    public final void finalMethod() {}

    protected void protectedMethod() {}

    void defaultMethod() {}
}
