package com.ohgiraffers.section01.insert;

import java.util.Scanner;

/* 설명.
*  Service 계층과 Repository(DAO.Data Access Object) 계층을 구분하고 XML파일에서부터 쿼리를 불러와서
*  Insert 해보기
*  */
public class Application2 {
    /* 설명. view이자 controller개념(입력 받은 데이터로 하나의 Menu객체로 만들기) //view 값을 입력받음, 값의 가공처리는 controller */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("메뉴의 이름을 입력하세요: ");
        String menuName = sc.nextLine();
        System.out.println("메뉴의 가격을 입력하세요:");
        int menuPrice = sc.nextInt();
        System.out.println("카테고리 코드를 입력하세요:");
        int categoryCode = sc.nextInt();
        System.out.println("판매 상태를 입력하세요");
        sc.nextLine();
        String orderableStatus = sc.nextLine();

        Menu menu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);

        MenuService service = new MenuService();
        service.registMenu(menu);

    }

}
