package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// 외부 리소스에서 커넥션을 만들어 반환함(close하면 안됨! 살아있는 connection을 줘야 함)
public class JDBTemplate {
    public static Connection getConnection() {                                  //모듈화
        Properties prop = new Properties();
        Connection con = null;

        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties")
            );
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("con = " + con);

            /* 설명. DML(i, u, d)실행 시 커밋 수동 설정(우리가 제거해, 자동모드를 수동모드로) */
            con.setAutoCommit(false);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;   //닫히지 않은 connection을 반환하는 식으로 만듬
    }

    // close메소드를 만들어서 main로직에서 호출하면 connection을 닫을 수 있게 함
    // connection이 넘어오면 닫는 작업을 여기서 함! => 모듈화 해!
    public static void close(Connection con) {
        try {
            if(con != null) con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt) {
        try {
            if(stmt != null) stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset) {
        try {
            if(rset != null) rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit(Connection con) {
        try {
           if(con != null) con.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void rollback(Connection con) {
        try {
            if(con != null) con.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





}

