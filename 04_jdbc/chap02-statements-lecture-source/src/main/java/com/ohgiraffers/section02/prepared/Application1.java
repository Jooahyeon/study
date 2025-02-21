package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBTemplate.close;
import static com.ohgiraffers.common.JDBTemplate.getConnection;


public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();

        /* 설명. <장점1> Statement보다 캐싱을 활용해 실행 속도가 더 빠르다.(최초 한 번 이후) */
        PreparedStatement pstmt = null;   // (준비된 트럭) 쿼리를 미리 준비해야 만들어짐
        ResultSet rset = null;

        try {
            /* 설명. Statement와 달리 PreparedStatement는 생성 당시에 쿼리가 있어야 한다. */
            // 왜 객체를 만들 때부터 있어야 하냐?! 캐싱을 해둠

            pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE"); //다중행, 컬럼 두개
            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.println(rset.getString("EMP_ID")
                + "," + rset.getString("EMP_NAME"));

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
