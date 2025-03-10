package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

// 서비스에 있는 메소드 하나 = 요청 하나
//SqlSession sqlSession = getSqlSession(); -> 전역으로 빼면 안됨(즉, 요청을 받을 때마다 서비스 메소드 안에 쓰라는 얘기)
public class MenuService {
    // 의존성 주입(new 활용)
    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }

    public List<MenuDTO> findAllMenus() {
        SqlSession sqlSession = getSqlSession();

        List<MenuDTO> menuList = menuDAO.selectAllMenus(sqlSession);

        sqlSession.close();

        return null;
    }

    // 사용자의 입력값을 같이 넘겨주는 것 (where절에 적힘)
    public MenuDTO findMenuByMeneCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        MenuDTO menu = menuDAO.selectMenuByMenuCode(sqlSession, menuCode);

        sqlSession.close();

        return menu;
    }

    public boolean registMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.insertMenu(sqlSession, menu);


        /* 설명. 성공 실패에 따라 트랜잭션 처리(commit/rollback), 안에서 수동으로 트랜잭션 처리 후 커넥션 닫기 */

        if (result == 1) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();

        }

        sqlSession.close();

        return result == 1 ? true : false;
    }

    public boolean modifyMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.updateMenu(sqlSession, menu);

        /* 설명. 성공 실패에 따라 트랜잭션 처리(commit/rollback), 안에서 수동으로 트랜잭션 처리 후 커넥션 닫기 */
        // 만약 업데이트(수정)하는 갯수에 따라 결과(result)가 달라질 수 있다(where절)   (result > 0 )
        if (result == 1) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();

        }

        sqlSession.close();

        return result == 1 ? true : false;
    }

    public boolean removeMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.deleteMenu(sqlSession, menuCode);


        /* 설명. 성공 실패에 따라 트랜잭션 처리(commit/rollback), 안에서 수동으로 트랜잭션 처리 후 커넥션 닫기 */
        // 만약 업데이트(수정)하는 갯수에 따라 결과(result)가 달라질 수 있다(where절)   (result > 0 )
        if (result == 1) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();

        }

        sqlSession.close();

        return result == 1 ? true : false;

    }
}
