package com.ohgiraffers.section01.test;

/* 설명. 테스트 클래스들은 클래스명 끝에 'Test/Test'를 붙여 작성한다. */
public class TestAnnotatinoTest {

    /* 수업 목표. */
    // 단위 테스트 : layered architecture에서 각 계층마다 단위 메소드를 테스트하는 것을 말한다.
    // 통합 테스트 : layer 단위가 아닌 전체 기능에 대해 테스트 하는 것을 말한다.
    // 테스트 케이스 : 테스트 대상이 되는 기능에 대해 시나리오 별로 어떤 것을 테스트 하는지에 대해 정의한 것.


    @Test
    @DisplayName("테스트 메소드가 통과하는지 확인")
    public void testMethod(){
        System.out.println("");
    }

    @Test
    public void 매개변수로_1과_3을_넘겼을_때_합계를_int형으로_잘_반환하지는지_확인()

}
