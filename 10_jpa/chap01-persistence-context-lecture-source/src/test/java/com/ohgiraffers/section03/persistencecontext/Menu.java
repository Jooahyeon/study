package com.ohgiraffers.section03.persistencecontext;


import jakarta.persistence.*;

@Entity(name = "section03_menu") // 모든 엔티티는 PK값을 달아야 한다!
// 엔티티는 Jpa가 관리할 속성임
// 하나의 설정안에 동일한 이름의 엔티티가 있으면 에러가 남
@Table(name="tbl_menu")
// 엔티티클래스는 테이블과 1:1매칭이 되어야 함
public class Menu {

    @Id
    @Column(name = "menu_code")
    //DBMS마다 전략을 다르게 가져가야함 -> 마리아디비에 맞는 설정
    /* 설명. Entity 객체를 만들 때 값을 넣지 않거나(DB의 auto ddl을 통해 Entity로) 테이블 생성 시 활용할 목적 */
//    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto-increment활용
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "manu_price")
    private int menuPrice;

    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "orderable_status")
    private String orderableStatus;

    public Menu() {
    }

    public Menu(int menuCode, String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
