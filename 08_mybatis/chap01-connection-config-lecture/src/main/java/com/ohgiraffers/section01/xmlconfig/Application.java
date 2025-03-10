package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {
    // 설정파일 및 쿼리 -> xml로 만들거야 , 여기서 sqlSession은 connection객체의 의미
    public static void main(String[] args) {

        String resource = "mybatis-config.xml";

        SqlSession session = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession(false);

            // 조회 결과가 다중행인경우 select list, select map 중에 골라서 사용
            // 조회 결과가 단일행인 경우 selectOne
            java.util.Date date1 = session.selectOne("mapper.selectNow");
            System.out.println("date1 = " + date1);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
}
