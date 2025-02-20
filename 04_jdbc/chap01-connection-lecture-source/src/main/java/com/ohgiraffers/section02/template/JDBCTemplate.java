package com.ohgiraffers.section02.template;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// 외부 리소스에서 커넥션을 만들어 반환함(close하면 안됨! 살아있는 connection을 줘야 함)
public class JDBCTemplate {
    public static Connection getConnection() {                                  //모듈화
        Properties prop = new Properties();
        Connection con = null;

        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties")
            );
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("con = " + con);

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
}
