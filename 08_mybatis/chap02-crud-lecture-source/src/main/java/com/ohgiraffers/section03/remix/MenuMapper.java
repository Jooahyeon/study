package com.ohgiraffers.section03.remix;

import com.ohgiraffers.section02.javaconfig.MenuDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/* 설명.
*  xml방식 (쿼리는 xml)과 자바 방식(dao가 간단한 추상 메소드)의 장점을 혼용하기 위한 방법 => remix방식
*  1. xml 파일은 매퍼용 인터페이스와 같은 이름으로 되어야 한다.
*  2. xml 파일은 매퍼용 인터페이스와 같은 경로에 위치 되어야 한다.
*  3. xml 파일의 네임스페이스는 매퍼용 인터페이스로 작성되어야 한다.(풀네임으로)
*  4. xml 파일의 쿼리 id와 매퍼용 인터페이스의 추상메소드가 일치되어야 한다.
*
*  쿼리는 xml(xml방식), dao를 간단한 인터페이스(자바방식)
* */

public interface MenuMapper {


    List<com.ohgiraffers.section02.javaconfig.MenuDTO> selectAllMenus();


    com.ohgiraffers.section02.javaconfig.MenuDTO selectMenu(int menuCode);


    int insertMenu(com.ohgiraffers.section02.javaconfig.MenuDTO menu);


    int updateMenu(MenuDTO menu);


    int deleteMenu(int menuCode);

}