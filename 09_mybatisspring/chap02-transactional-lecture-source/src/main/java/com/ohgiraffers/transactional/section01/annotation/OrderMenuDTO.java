package com.ohgiraffers.transactional.section01.annotation;

// 사용자가 몇번 메뉴를 몇개 주문할거다를 쓰는 곳
// 테이블하고 1:1대칭이 아니여도 됨 사용자가 입력한 값을 받아 다른 곳에 넘기기만 하는 친구임(값을 담아 뭉쳐서 옮기는 친구가 디티오)
// 롬복 체크하면 다 만들지 않아도 돼~ (우린 체크안했우니 다 썼어)
public class OrderMenuDTO {

    private int menuCode;                   // 고른 메뉴 번호
    private int orderAmount;                // 고른 메뉴 갯수

    public OrderMenuDTO() {
    }

    public OrderMenuDTO(int menuCode, int orderAmount) {
        this.menuCode = menuCode;
        this.orderAmount = orderAmount;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "OrderMenuDTO{" +
                "menuCode=" + menuCode +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
