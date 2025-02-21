package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBTemplate.close;
import static com.ohgiraffers.common.JDBTemplate.getConnection;         // import할 때 끝이 메소드임

// 구형트럭~
public class Application1 {
    public static void main(String[] args) {

        /* 설명. Connection 객체 생성*/
        Connection con = getConnection();                       // 길
        System.out.println("con = " + con);

        Statement stmt = null;                                  // 트럭

        /* 설명. 실행될 쿼리가 조회인 경우*/
        ResultSet rset = null;                                  // 결과물 -> select문에 다녀옴(조회 할 예정) int가 반환형

        try {
            stmt = con.createStatement(); //트럭을 만들어준 것

            // 1) 디비에서 뭘 뽑아올지 고려 2) 다중행인지 단일행인지 알고 틀에 맞춰 가져와
            // 디비 콘솔창에서 먼저 돌려보고 뭘 가져올지 확인한 후 가져오는게 보통 순서
            rset = stmt.executeQuery("SELECT * FROM EMPLOYEE");    // executeQuery => select문일 때 사용(조회)
                                                                       // executeupdate => select문 아닐 때 사용(조회아님)
            /* 설명. 다중행 결과는 반복문 활용*/
            while (rset.next()) {

                /* 설명. 반복문 안에서의 rset은 단일행으로 해석 */
                System.out.println(rset.getString("EMP_NAME") + ", "
                + rset.getInt("SALARY"));                               // DB의 자료형별로 자바에 뽑아야해
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {                                                                 // 닫는 순서는 객체 만든 순서 반대로
            close(rset);
            close(stmt);
            close(con);
        }
    }
}


// * 고려할 점
// 1) 쿼리의 종류를 먼저 알고 있기
// 2) 쿼리 결과가 다중행인지 단일행인지 확인 (다중행 - 반복문, 단일행 - if문 등)
// 디비가 돌아가는지 확인하는게 먼저임
