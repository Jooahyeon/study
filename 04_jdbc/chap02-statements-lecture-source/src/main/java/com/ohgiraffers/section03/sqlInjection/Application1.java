package com.ohgiraffers.section03.sqlInjection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBTemplate.close;
import static com.ohgiraffers.common.JDBTemplate.getConnection;
// sqlinjection => id랑 pw를 넣으라 했는데 쿼리를 넣어 보안이 뚫리는 경우
public class Application1 {
    private static String empId = "200";
    private static String empName = "' OR 1=1 AND EMP_ID = '200";

    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId
                + "' AND EMP_NAME = '" + empName + "'";
        // and > or (우선순위)

        System.out.println("query = " + query);

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if (rset.next()) {
                System.out.println(rset.getString("EMP_NAME") + "님 환영합니다");
            } else {
                System.out.println("해당 회원은 존재하지 않습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
          close(rset);
          close(stmt);
          close(con);
        }
    }
}
