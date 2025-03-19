package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Category엔티티와 pk값의 자료형 입력(int)
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /* 설명. findAll() 메소드를 사용할 수 있지만 jpql 또는 native query로 작성할 수도 있음을 확인 */
    // 직접 쿼리 작성 가능 (jpql구문을 메소드 붙여 사용하는 방법)
//    @Query(value="SELECT m FROM Category m ORDER BY m.categoryCode ASC")
    @Query(value = "SELECT CATEGORY_CODE, CATEGORY_NAME, REF_CATEGORY_CODE FROM TBL_CATEGORY"
            + "ORDER BY CATEGORY_CODE ASC", nativeQuery = true)
    List<Category> findAllCategories();
}
