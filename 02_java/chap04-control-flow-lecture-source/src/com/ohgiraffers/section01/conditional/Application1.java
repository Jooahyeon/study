package com.ohgiraffers.section01.conditional;

public class Application1 {

    public static void main(String[] args) {
        //각 클래스별로 모듈화 -> 관련있는 것들만 따로 빼둔 것 (modulation)
        //실행용
//        A_if aClass = new A_if();

        /* 설명. 단독 if문 흐름 확인용 메소드 호출 */
//        aClass.testSimpleIfStatement();             //낙타봉?표기법?
        // 오류있음 강사님 코드 참고하여 수정해야해

        /* 설명. 중첩 if문 흐름 확인용 메소드 호출 */
//        aClass.testNestedIfStatement();


//        B_ifElse bClass = new B_ifElse();
//
//        /*설명. 단독 if-else문 흐름 확인용 메소드 호출*/
//         bClass.testSimpleIfElseStatement();
//
//         /*설명. 중첩 if-else문 흐름 확인용 메소드 호출*/
//        bClass.testNestedIfElseStatement();

        /*설명. 단순 if-else문 흐름 확인용 메소드 호출 */
//        C_ifElseIf cClass = new C_ifElseIf();

//        cClass.testSimpleIfElseIfStatement();

        /*설명. 중첩 if-else if문 흐름 확인용 메소드 호출*/
//        cClass.testNestedIfElseIfStatement();

        /*설명. static 메소드로 switch문 흐름 확인용 메소드 호출*/
        D_switch.testSimpleSwitchStatement();                   //클래스 만드는건 어떻게?


    }
}
