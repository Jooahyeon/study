package com.ohgiraffers.mybatisspring.section01.factorybean;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


// 서비스계층에서 커넥션객체 의존성 주입 받음
@Service
public class MenuService {

    private final SqlSessionTemplate sqlSession;

    @Autowired
    public MenuService(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    /* 설명. 메ㄴ뉴의 활성화 상태("Y"/"N")에 따른 메뉴 조회 */
    public List<MenuDTO> fingAllMenuByOrderableStatus(String orderableStatus) {
        return sqlSession.getMapper(MenuMapper.class).selectAllMenuByOrderableStatus(orderableStatus);
    }


}
