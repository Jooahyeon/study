package com.ohgiraffers.transactional.section01.annotation;

import org.apache.ibatis.annotations.Mapper;

// 어노테이션만 달아도 매퍼 등록되고 콩으로도 관리됨(객체가 됨, 하위 구현체가 생성됐다는 ㅓㄱㅅ)
// -> 얘네 서비스에서 갖다 쓸거야
@Mapper
public interface OrderMapper {
}
