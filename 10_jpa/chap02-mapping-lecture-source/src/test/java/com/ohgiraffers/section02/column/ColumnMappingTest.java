package com.ohgiraffers.section02.column;
import com.ohgiraffers.section01.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class ColumnMappingTest {

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
    public void 컬럼에서_사용하는_속성_테스트() {
        // given
        com.ohgiraffers.section01.entity.Member member = new com.ohgiraffers.section01.entity.Member();
        member.setMemberNo(1);                              // PK 값이라 Notnull 제약조건 걸림
        member.setMemberId("user01");
        member.setMemberPwd("pass01");
        member.setNickName("홍길동");
        member.setPhone("010-1234-5678");
        member.setEmail("hong@gamil.com");

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(member);                      // insert문 날아감

        // then
        com.ohgiraffers.section01.entity.Member foundMember = entityManager.find(Member.class, 1);
        foundMember.setNickName("동해번쩍");

        transaction.commit();
    }

}
