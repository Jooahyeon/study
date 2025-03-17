package com.ohgiraffers.springdatajpa.menu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_menu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Menu {

        @Id
        @Column(name = "menu_code")
        private int menuCode;

        @Column(name = "menu_name")
        private String menuName;

        @Column(name = "menu_price")
        private int menuPrice;

        @Column(name="category_code")       // FK제약조건이 있는 컬럼명(자식테이블에 있는 컬럼명만 쓴다)
        private int categoryCode;                      // 메뉴 1개가 카테고리 엔티티 객체를 몇개 가지는지(List<타입>/타입)

        @Column(name = "orderable_status")
        private String orderableStatus;
}
