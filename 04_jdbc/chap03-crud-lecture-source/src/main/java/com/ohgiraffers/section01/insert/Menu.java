package com.ohgiraffers.section01.insert;
// dto -> 데이터를 옮기는 객체(객체를 값을 뭉쳐서 옮겨다니는 클래스)
public class Menu {
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String oderableStatus;

    public Menu() {
    }

    public Menu(int menuCode, String menuName, int menuPrice) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }


    public Menu(String menuName, int menuPrice, int categoryCode, String oderableStatus) {

        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.oderableStatus = oderableStatus;
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

    public String getOderableStatus() {
        return oderableStatus;
    }

    public void setOderableStatus(String oderableStatus) {
        this.oderableStatus = oderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", oderableStatus='" + oderableStatus + '\'' +
                '}';
    }
}
