package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface Mapper {

    // 쿼리의 메소드를 매핑한 과정
    @Select("SELECT NOW()")
    Date selectNow();
}
