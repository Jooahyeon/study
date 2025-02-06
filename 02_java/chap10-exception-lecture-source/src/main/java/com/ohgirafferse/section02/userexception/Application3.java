package com.ohgirafferse.section02.userexception;

import com.ohgirafferse.section02.userexception.exception.MoneyNegativeException;
import com.ohgirafferse.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgirafferse.section02.userexception.exception.PriceNegativeException;

public class Application3 {
    public static void main(String[] args) {

        ExceptionTest et = new ExceptionTest();
        try {
//            et.checkEnoughMoney(30000, 40000);
//            et.checkEnoughMoney(-30000, 40000);
//            et.checkEnoughMoney(30000, -40000);
            et.checkEnoughMoney(130000, 40000);

            /*설명. multi-catch 구문은 두 개 이상의 예외를 (|) 를 사용해서 하나의 catch 블럭에서 처리할 수 있다. */
        } catch (PriceNegativeException | MoneyNegativeException | NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("어떤 예외든 커몬!");
            System.out.println("어떤 예외든 메세지는 : " + e.getMessage());
        }
        System.out.println("프로그램을 종료합니다");
    }

}
