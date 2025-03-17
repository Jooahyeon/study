package com.ohgiraffers.section01.simple;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class SimpleJPQLTest {
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

    @Test
    public void TypedQuery를_이용한_단일행_단일열_조회_테스트() {
        // mariadb의 select문으로 치환(dialect)
        // 테이블 대신 엔티티, 컬럼 대신 필드명
        String jpql = "SELECT menuName FROM menu_section01 WHERE menuCode = 7";
        // 꺼낼 때 기본값(object타입) -> 원하는 타입으로 설정시 다운캐스팅 필요
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);           // 순수 jpa
        String resultMenuName = query.getSingleResult();                                    // 단일행 단일열 조회니 string
        System.out.println("resultMenuName = " + resultMenuName);

    }

    // 타입 지정 안하고
    @Test
    public void Query를_이용한_단일행_단일열_조회_테스드() {
        // mariadb의 select문으로 치환(dialect)
        // 테이블 대신 엔티티, 컬럼 대신 필드명
//        String jpql = "SELECT menuName FROM menu_section01 WHERE menuCode = 7";
//        // 꺼낼 때 기본값(object타입) -> 원하는 타입으로 설정시 다운캐스팅 필요
//        Query query = entityManager.createQuery(jpql);           // 순수 jpa
//        Object resultMenuName = query.getSingleResult();                                    // 단일행 단일열 조회니 string
//        System.out.println("resultMenuName = " + resultMenuName);
//
//        Assertions.assertTrue(resultMenuName instanceof String);
//        Assertions.assertEquals("민트미역국", resultMenuName);


        /* 설명. 단일행 일부 다중열(Object[]일 시) */
        /* 설명. jpql을 통해 일부분의 조회 결과 컬럼을 받아내는 것을 projection이라고 한다. */
        // 프로젝션 : 일부분의 컬럼만 조회해내는 것
//        String jpql = "SELECT m.menuName, m.menuPrice FROM menu_section01 m WHERE m.menuCode = 7";
//        Query query = entityManager.createQuery(jpql);
//        List<Object[]> resultColums = query.getResultList();
//
//        Object[] resultRow = resultColums.get(0);
//        Arrays.stream(resultColums.get(0)).forEach(System.out::println);
//
//        Assertions.assertTrue(resultRow[0] instanceof String);
//        Assertions.assertTrue(resultRow[0] instanceof Integer);

    }

    // 1차 캐시로 관리되는 , 모든 컬럼으로 조회해 (다중행 단일열, 단일행 다중열 조회일 시 사용하는게 좋음)
    @Test
    public void TypedQuery를_이용한_다중행_다중열_조회_테스트() {
        String jpql = "SELECT m FROM menu_section01 m";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);

        List<Menu> foundMenuList = query.getResultList();
        foundMenuList.forEach(System.out::println);

        Assertions.assertTrue(!foundMenuList.isEmpty());
    }

    @Test
    public void distinct를_활용한_중복제거_여러_행_조회_테스트() {

         /* 설명. 메뉴에 할당된 카테고리의 종류를 조회하는 jpql구문 */
        String jpql = "SELECT DISTINCT m.categoryCode FROM menu_section01 m";
        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        List<Integer> categoryCodeList = query.getResultList();
        categoryCodeList.forEach(System.out::println);

        Assertions.assertTrue(!categoryCodeList.isEmpty());
    }

    @Test
    public void in_연산자를_활용한_조회_테스트() {
        String jpql = "SELECT m FROM menu_section01 m WHERE m.categoryCode IN (6,10)";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();

        menuList.forEach(System.out::println);
        Assertions.assertTrue((!menuList.isEmpty()));

    }

    @Test
    public void Like_연산자를_활용한_조회_테스트() {
        String jpql = "SELECT m FROM menu_section01 m WHERE m.menuName LIKE '% 마늘 %'";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();

        menuList.forEach(System.out::println);
        Assertions.assertTrue((!menuList.isEmpty()));

    }


}
