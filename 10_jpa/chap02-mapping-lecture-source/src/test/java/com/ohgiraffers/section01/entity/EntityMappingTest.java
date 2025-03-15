package com.ohgiraffers.section01.entity;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

public class EntityMappingTest {
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
    public void 테이블_만들기_테스트() {

        // given
        Member member = new Member();
        member.setMemberNo(1);                              // PK 값이라 Notnull 제약조건 걸림
        member.setMemberId("user01");
        member.setMemberPwd("pass01");
        member.setNickName("홍길동");
        member.setPhone("010-1234-5678");
        member.setEmail("hong@gamil.com");
        member.setAddress("서울시 서초구");
        member.setEnrollDate(new java.util.Date());
        member.setMemberRole("ROLE_MEMBER");            // 디비에 반드시 접두사가 붙어야 함.-> 모델링에서 varchar 고려
        member.setStatus("Y");

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(member);                      // insert문 날아감

        // then
        // 인지(find, persist)를 시킨 객체를 수정해야 update가 날아감
        Member foundMember = entityManager.find(Member.class, 1);
        foundMember.setNickName("동해번쩍");

        transaction.commit();
    }
}
