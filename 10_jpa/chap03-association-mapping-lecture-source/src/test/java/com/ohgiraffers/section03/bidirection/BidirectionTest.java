package com.ohgiraffers.section03.bidirection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class BidirectionTest {

    private static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    /* 설명. 양방향 연관관계를 통해 만들 엔티티 갯수는 줄어들지만 경우의 수를 모두 고려하여 설계해야 한다.
     *   (특히 순환 참조를 고려해야 한다.(toString() 작성 시 조심(Join의 대상 제외)해야 한다_안빼면 계속 가져오는 순환참조가 발생하므로))
     * */

    @Test
    public void 양방향_연관관계_매핑_조회_테스트() {
        int menuCode = 10;
        int categoryCode = 10;

        /* 설명. 연관관계의 주인(자식 엔티티)은 한번에 left join문으로 관계를 맺은 엔티티를 조회해 온다. */
        Menu foundMenu = entityManager.find(Menu.class, menuCode);              // ManyToOne이라 조인문으로 날아감(조인+셀렉)
        System.out.println("foundMenu = " + foundMenu);
        // 객체 그래프 탐색(이런경우 순환참조 막고 조인할 수 있음)
        System.out.println("10번 메뉴의 카테고리: " + foundMenu.getCategory());       // 메뉴를 먼저 보고 카테고리를 가져옴

        /* 설명. 양방향은 부모에 해당하는 엔티티는 가짜 연관관계이고 필요 시 연관 관계 엔티티를 조회하는 쿼리로 작성된다.
        *   (FetchType.LAZY처럼 동작한다.)
        * */
        Category foundCategory = entityManager.find(Category.class, categoryCode);// OneToMany (셀렉만)
        System.out.println("foundCategory = " + foundCategory);                   // toString시점-> 한쪽이라도 끊어야 순환참조 X
        System.out.println("10번 카테고리의 메뉴들 : " + foundCategory.getMenuList()); // menu에 대한 select 발생

    }

}
