package com.ohgiraffers.section03.bidirection;

import jakarta.persistence.*;

import java.util.List;

// 부모테이블(자식에 의해서 매핑이 되는 경우)
@Entity(name = "bidirection_menu")
@Table(name = "tbl_category")
public class Category {


    @Id
    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "category_name")
    private String cateogryName;

    @Column(name = "ref_category_code")
    private Integer refCategoryCode;

    //mappedBy : 메뉴엔터티에 의해서 매핑이 되었다(수동태 느낌)
    // 자식 테이블 필드의 이름을 쓴 것
    @OneToMany(mappedBy = "category")
    private List<Menu> menuList;            // 카테고리 한개는 메뉴를 여러개 가지니 list

    public Category() {
    }

    public Category(int categoryCode, String cateogryName, Integer refCategoryCode, List<Menu> menuList) {
        this.categoryCode = categoryCode;
        this.cateogryName = cateogryName;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCateogryName() {
        return cateogryName;
    }

    public void setCateogryName(String cateogryName) {
        this.cateogryName = cateogryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "CategoryAndMenu{" +
                "categoryCode=" + categoryCode +
                ", cateogryName='" + cateogryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
//                ", menuList=" + menuList +
                '}';
    }
}
