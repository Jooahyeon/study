package com.ohgiraffers.section02.template;

import java.sql.Connection;
import java.sql.SQLException;
//

/* 설명. 다른 클래스의 static 메소드를 클래스명을 쓰지 않고 메소드만 호출 할려면 import static을 한다. */
//import static 메소드 이름까지 씀(메소드명만 호출하면 되게끔 모듈화 한 것)
import static com.ohgiraffers.section02.template.JDBCTemplate.close;
import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;

public class Application {
    public static void main(String[] args) {
        Connection con = getConnection();                   //다른 클래스에 있는 static메소드를 소속을 안밝히고 싶을 때 이렇게 함

        /* 설명. 비즈니스 로직(트랜잭션 관련) 실행*/
        System.out.println("con = " + con);
        System.out.println("Connection 객체를 활용해 DB와 SQL로 소통");
        // 반환받은 con을 다쓰면 여기서 닫아줌(close)
        close(con);


        //아래처럼 t-c문까지 쓰면 너무 길어서 위처럼 모듈화 해둠
//        try {
//            if(con != null) con.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }
}
