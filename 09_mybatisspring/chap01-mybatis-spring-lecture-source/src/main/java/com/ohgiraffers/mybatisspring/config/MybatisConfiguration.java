package com.ohgiraffers.mybatisspring.config;

import com.ohgiraffers.mybatisspring.section01.factorybean.MenuMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* 설명.나중에 간편히 할 수 있으나 chap01에서는 추가적인 설정을 할 예정 */
@Configuration
public class MybatisConfiguration {
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.jdbc-url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    // HikariDataSource 커넥션풀을 효율적으로 관리해주기 위해서 만듬- > 알아서 커넥션 객체 만들어서 사용자가 몰리는 경우 알아서 처리
    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource(){
       HikariDataSource dataSource  = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        // 효율적 -> 트래픽이 얼마나 몰리는지 모니터링을 통해 알 수 있는 것임(배경지식)
        /* 설명. 데이터베이스 연결 시도 유지 시간_ db가연결이 안되는 경우 얼마동안 시도를 하겠다는 의미 */
        dataSource.setConnectionTimeout(30000);             // 30초

        /* 설명. 데이터 베이스 유효 시간(커넥트 되고 이후 쿼리가 안날아 가는 걸 대기하는 시간) */
        dataSource.setIdleTimeout(600000);                  // 10분

        /* 설명. 데이터 베이스 연결 최대 유지 시간 */
        dataSource.setMaxLifetime(1800000);                 // 30분

        dataSource.setMaximumPoolSize(50);

        return dataSource;
    }

    // bean을 설정한 것
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.addMapper(MenuMapper.class);

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());                    // datasource 등록
        factoryBean.setConfiguration(configuration);                // mapper 등록

        return factoryBean.getObject();
    }


    // 커넥션객체 -> 서비스계층에 의존성주입해줌
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }


}
