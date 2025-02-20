package com.ohgiraffers.section01.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//DB와 연동 관련된 것들은 sql패키지로 사용

//왜 이렇게 해야해? 왜 외부소스파일로 빼서 불러오는 식으로 해야해?
// -> 1) 외부 파일은 깃허브에 안올라가고 프로펄티 파일 자체는 의미가 없음, 자바 코드가 컴파일이 일어나는 것,
// 자바 프로젝트로 압축파일 jar가 만들어져 배포됨, 해당 리눅스 계정에 접속하면 누구든 해당 자바 사용 가능
// 이때 수정할 사항이 생기는 경우 자바파일을 수정하는 게 아닌 jar파일을 수정해야 함
// jar서버를 재인식하지 않더라도 서버를 무중단으로 수정할 수 있음. (나중에 배움) => msa
// 2) 실제 값을 숨김(자바코드에서는 value가 보이지 않게 함)
// 3) 비개발자도 수정할 수 있다.

public class Application2 {
    public static void main(String[] args) {
        Properties prop = new Properties();                     // Properties객체 생성
        Connection con = null;

        try {                                                   // FileReader 한글이 있어도 읽게 해줌(t-c로 감싸줌)
            prop.load(new FileReader("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties")
            );

            // properties에 있는 변수  key로 뽑기
            // 외부파일로부터 실제 값들이 노출이 되지 않도록 key로 불러옴
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
        } finally{
            // 스프링부트 @Transactional에서 알아서 닫아줌(close) "개념은 알고 있어!"
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
