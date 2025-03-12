package com.ohgiraffers.transactional.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

// 쿼리가 있는 개념을 설정에 넣어줘야 함 @MapperScan -> 쿼리가 있는 매퍼만 지정해주면 됨
// 보통 설정은 다른 패키지에 해둠(보통 설정이 안으로 들어가기때문에 스캔 범위를 상위로 둠)
@Configuration
@MapperScan(basePackages = "com.ohgiraffers.transactional", annotationClass = Mapper.class)
public class MybatisConfiguration {
}
