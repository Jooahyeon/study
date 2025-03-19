package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    List<Menu> findByMenuPriceGreaterThan(int menuPrice);
    // JpaRepository를 상속아서 하위 구현객체를 알아서 생성해줌 -> 의존성 주입을 받을 수 있게 됨(콩이되어서!)
    // 복합키면 <>안에 복합키를 작성해야한다.
}
