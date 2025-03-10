package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;


public class Application {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/jdbcdb";
    private static String user = "root";
    private static String password = "mariadb";

    public static void main(String[] args) {
        /* 설명.
        * JdbcTransactionFactory : 수동 커밋
        * ManagedTransactionFactory : 자동 커밋
        *  ===================================
        * PoolDataSource : ConnectionPool 사용  -> hikaricp가 내장되어 있음
        * UnPooledDataSource : ConnectionPool 미사용
        * */

        Environment environment = new Environment(
                // java/xml로 두가지로 만들어볼 예정
                "dev",
                new JdbcTransactionFactory(),                            // 수동커밋
                // PooledDataSource :  connection객체를 미리 만들어두고 사용
                new PooledDataSource(driver, url, user, password)
        );

        // 일꾼에게 줄 설계도를 만드는 것
        Configuration configuration = new Configuration(environment);
        // mapper 포함
        configuration.addMapper(Mapper.class);

        /* 설명.
        * SqlSessionFactory: SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
        * SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할
        *
        * build() : 설정에 대한 정보를 담고 있는 Configuration타입의 객체(java방식) 혹은 외부 설정 파일과 연결된
        *           stream을 매개변수로 전달(xml 방식)하면 SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드
        * */


        // 설계도를 갖고 만드는 과정 (java 방식)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        // false를 작성해야 수동 커밋 완성, connection 객체 생성
        SqlSession session = sqlSessionFactory.openSession(false);

        // 트랜잭션단위 실행되는 것
        Mapper mapper = session.getMapper(Mapper.class);

        java.util.Date date = mapper.selectNow();               // 내부적으로 preparedstatement가 도는 것
        System.out.println("date = " + date);

        session.close();                                        // connection객체 다 쓰면 닫아줌
    }
}
