package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBTemplate.close;
import static com.ohgiraffers.common.JDBTemplate.getConnection;


// 사용자가 입력한 값으로 조회하는 클래스

public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();   // 커넥션 객체는 사용자마다 하나씩 할당되는 객체 -> 사용자 요청당 해당 객체가 하나씩 할당
        Statement stmt = null;              // Statement 개념면접에 자주 나옴 잘 알아둬
        ResultSet rset = null;

        try {
            stmt = con.createStatement();

            /* 설명. 사용자로부터 사번을 입력받아 사원 조회 */
            Scanner sc = new Scanner(System.in);
            System.out.println("사번 입력해주세요 :");
            int empId = sc.nextInt();                                   // DB에서는 varchar형이나 묵시적 형변환 발생됨
                                                                        // convert, cast 함수로 형변환해야하는걸 자동으로 해줌

            /* 설명. java에서 쿼리를 작성해 전달하게 될 때는 ;(세미콜론)을 생략 */
            // 자바에서 쿼리 날릴 땐 세미콜론 빼! 에러발생함
            // 쿼리는 문자열 형태로 만들어야 함
            String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";
            rset = stmt.executeQuery(query);                            // 짐 싣어!

            if (rset.next()) {
                System.out.println("조회하신 " + empId + "번 사원은 " + rset.getString("EMP_NAME") + "입니다.");
            } else {   // 없는 사원을 입력 받았을 때
                System.out.println("해당 사원은 존재하지 않습니다. ");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(rset);
            close(stmt);
        }

    }
}
