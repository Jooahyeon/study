package com.ohgiraffers.section01.xml;


import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Map;

// MenuMapper 같은 위치이자 같은 풀네임을 가진 xml파일 생성해야 함
public interface MenuMapper {

    // selectMenuByPrice 해당 메소드의 쿼리 생상 xml에서!
    List<MenuDTO> selectMenuByPrice(int maxPrice);

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuByRandomMenuCode(List<Integer> randomList);

    List<MenuDTO> searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuByMameOrCategory(Map<String, Object> criteria);

    int updateMenu(Map<String, Object> criteria);
}
