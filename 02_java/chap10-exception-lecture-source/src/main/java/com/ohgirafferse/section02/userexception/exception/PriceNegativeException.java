package com.ohgirafferse.section02.userexception.exception;

public class PriceNegativeException extends  Exception {
    public PriceNegativeException(String message) {
        super(message);             //매개변수한개짜리를 만들면 기본생성자가 없는 것!
        // 그래서 호출한 곳에서 메세지가 없는 것이 불가능
        //
    }
}
