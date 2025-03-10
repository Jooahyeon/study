package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

// result.html 로 생각해~
// 메뉴DAO 리스트의 성공여부를 조회?
public class PrintResult {
    public void printMenus(List<MenuDTO> menuList) {
//        menuList.forEach(menu -> System.out.println(menu));
        menuList.forEach(System.out::println);
    }

    public void printErrorMessage(String message) {
        System.out.println("에러 메시지: " + message);
    }

    public void printMenu(MenuDTO menu) {
        System.out.println("조회 성공한 menu = " + menu);
    }

    /* 설명. DML 작업 결과 출력 */
    public void printSuccessMessage(String statusCode) {
        String successMessage = "";
        switch (statusCode) {
            case "regist": successMessage = "신규 메뉴 등록에 성공하였습니다."; break;
            case "modify": successMessage = "기존 메뉴 수정에 성공하였습니다"; break;
            case "remove": successMessage = "기존 메뉴 삭제에 성공하였습니다.";

        }
        System.out.println(successMessage);
    }
}
