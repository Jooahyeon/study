package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    // 싱클톤 방식을 적용한 팩토리 패턴(설정을 가지고 리소스가 하나인 팩토리 생성)

    private static SqlSessionFactory sqlSessionFactory;

    // lazy singleton (sqlSessionFactory == Null일 경우)
    public static SqlSession getSqlSession() {
        if (sqlSessionFactory == null) {
            String resource = "com/ohgiraffers/section01/xmlconfig/mybatis-config.xml";
            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory.openSession();
    }
}
