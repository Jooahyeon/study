package com.ohgiraffers.section01.manyToone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "category_section01")
@Table(name = "tbl_category")
public class Category {

    @Id
    @Column(name = "category_code")
    private int categoryCode;

    // 자바클래스에서 Null을 넣고 싶으면 래퍼클래스 형태로 해줘야함(notnull제약조건을 걸 수 없는 경우 참조자료형으로 작성)
//    private int refCategoryCode;

    @Column(name = "category_name")
    private String categoryName;

    /* 설명. Null값이 들어갈 수 있는 엔티티의 필드는 참조자료형을 쓰자 */
    @Column(name ="ref_category_code")
    private Integer refCategoryCode;

    public Category() {

    }

    public Category(int categoryCode, int refCategoryCode, String categoryName, Integer refCategoryCode1) {
        this.categoryCode = categoryCode;
        this.refCategoryCode = refCategoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode1;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public void setRefCategoryCode(int refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", refCategoryCode=" + refCategoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}

