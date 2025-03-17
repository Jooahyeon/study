package com.ohgiraffers.springdatajpa.menu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="tbl_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Category {

    @Id
    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    /* 설명. Null값이 들어갈 수 있는 엔티티의 필드는 참조자료형을 쓰자 */
    @Column(name ="ref_category_code")
    private Integer refCategoryCode;

}
