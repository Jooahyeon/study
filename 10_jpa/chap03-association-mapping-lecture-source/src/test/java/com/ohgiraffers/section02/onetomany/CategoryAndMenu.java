package com.ohgiraffers.section02.onetomany;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "category_and_menu")
@Table(name = "tbl_category")
public class CategoryAndMenu {


    @Id
    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "category_name")
    private String cateogryName;

    @Column(name = "ref_category_code")
    private Integer refCategoryCode;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_code")     // 자식 테이블의 fk 컬럼
    private List<Menu> menuList;            // 카테고리 한개는 메뉴를 여러개 가지니 list

    public CategoryAndMenu() {
    }

    public CategoryAndMenu(int categoryCode, String cateogryName, Integer refCategoryCode, List<Menu> menuList) {
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
