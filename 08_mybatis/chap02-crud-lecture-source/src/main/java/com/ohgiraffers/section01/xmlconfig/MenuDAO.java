package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {
    public List<MenuDTO> selectAllMenus(SqlSession sqlSession) {
        // DB에 얘가 다녀오고 반환함...
        // 설정파일에 해당 매퍼를 등록해야해!
        return sqlSession.selectList("MenuMapper.selectAllMenus");
    }

    public MenuDTO selectMenuByMenuCode(SqlSession sqlSession, int menuCode) {
        return sqlSession.selectOne("MenuMapper.selectMenu", menuCode);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.update("MenuMapper.updateMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, int menuCode) {
        return sqlSession.delete("MenuMapper.deleteMenu", menuCode);
    }
}
