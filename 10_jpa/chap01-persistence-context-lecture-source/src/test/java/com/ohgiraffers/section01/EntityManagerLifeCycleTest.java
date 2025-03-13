package com.ohgiraffers.section01;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

// 끝에 test 붙여줘(관례상 원칙)
public class EntityManagerLifeCycleTest {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    // 공장은 한번만 지으면 돼
    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    // 매니저는 각 요청마다여서 each
    @BeforeEach
    public void initManger() {

        /* 설명. EntityManager가 생성될 때마다 고유의 새로운 영속성 컨텍스트(Entity를 관리하는 자바의 창고)가 생성된다. */
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void closeManger() {
        entityManager.close();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @Test
    public void 엔티티_매니저_팩토리와_엔티티_매니저_생명주기_확인1(){
        System.out.println("entityManagerFactory.hashCode1: " + entityManagerFactory.hashCode());
        System.out.println(entityManager.hashCode());
    }

    @Test
    public void 엔티티_매니저_팩토리와_엔티티_매니저_생명주기_확인2(){
        System.out.println("entityManagerFactory.hashCode2: " + entityManagerFactory.hashCode());
        System.out.println("entityManager.hashCode(): " + entityManager.hashCode());
    }
}
