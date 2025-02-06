package com.ohgirafferse.section01.exception;

public class ExceptionTest {

    public void checkEnoughMoney(int price, int money) throws ArithmeticException /*Exception도 가능*/ {
        if (price >= money) {
            System.out.println(price + "원 상품을 구입하기 위한 금액이 충분합니다");
            return;
//            System.out.println("가지고 계신 돈은 ");
        }
//        throw + 예외 객체 => 예외가 발생했다는 것

        /*설명 예외 상황에 Exception을 상속받는 클래스의 객체를 생성하고 throw로 예외상황 수동 발생시킴 */
        throw new ArithmeticException("호주머니 사정 딱함");
        //예외객체(Exception타입의 객체를 생성하여 throw를 하면 예외가 발생한 것) 물려받음
        // throws로 예외가 발생한 곳에 해당 메소드를 던짐 (throws-> 여러개를 던진다 가능)
        // 던져지 것을 호출한 곳에서 처리함

    }

}
