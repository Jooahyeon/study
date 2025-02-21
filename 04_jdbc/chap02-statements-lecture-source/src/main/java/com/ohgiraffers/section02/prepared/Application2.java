package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBTemplate.close;
import static com.ohgiraffers.common.JDBTemplate.getConnection;
// <장점2> placehorder(?)을 사용해 하나의 문자열 형태로 작성 가능함
public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("사번을 입력하세요: ");
        String empId = sc.next();

        System.out.println("퇴사 여부를 입력하세요(Y/N)");
        String entYn = sc.next();
//        String entYn = sc.next().toUpperCase(); // 일반적으로 대소문자 신경 안쓰나 리눅스 환경에서는 구분함

        // ? -> placeholder 이미 세팅이 되어 있어 속도가 빠름
        //  ? => 사용자가 화면(UI)에서 입력하는 입력창 의미
        try {
            /* 설명. PreparedStatementsms Statement와는 달리 Placehoder(?)를 활용해 하나의 문자열 형태로 작성이 가능하다. */
            // 단일행 다중행 구분해야하는데 어떻게하징?
            pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME WHERE EMP_ID = ? AND ENT_YN = ?");
            pstmt.setString(1, empId);          // 넣는 자료형에 맞춰서 'set자료형()'형태로 쓰면 됨!
            pstmt.setString(2, entYn);

            rset = pstmt.executeQuery(); //결과 돌아옴
            if (rset.next()) {
                System.out.println("조회하신 사원의 사번과 이름은 " + rset.getString("EMP_ID")
                        + "번의" + rset.getString("EMP_NAME") + "입니다.");
            } else {
                System.out.println("조건에 해당하는 사원이 없습니다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
