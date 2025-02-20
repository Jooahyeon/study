package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* 수업목표. 해당 DBMS 경로와 계정에 맞는 Connection 객체를 생성할 수 있다.(feat. 해당 DBMS driver 라이브러리 필요) */
// 자바랑 디비랑 연결하는 길이 connection객체 -> finally로 닫아줘야 함(할 일 끝내면 연결을 끊어야 함, 스트림은 열면 반드시 반납 할 것)
// 이런식으로 깃이나 협업툴에 올라가면 안돼!
public class Application1 {
    public static void main(String[] args) {
        Connection con = null;                                            // 자바에서 디비로 가는 길 생성 ,

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");          // driver 객체가 static영역에 생성 (누가?)
                                                                          // (각 DBMS마다 driver모양이 다름)

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb", // (어디로??)
                                                                          // localhost : DB가 떠있는 서버 컴퓨터
                                                                          // 3306 : DB서버가 몇번 포트가 도는지 입력
                                                                          // jdbcdb : 해당 공간 지정
                    "root",
                    "mariadb");                           // connection객체를 통해 mariadb로 감

            System.out.println("Connection 객체: " + con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
