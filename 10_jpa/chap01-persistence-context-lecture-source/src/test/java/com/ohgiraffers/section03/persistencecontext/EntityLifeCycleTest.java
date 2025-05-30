package com.ohgiraffers.section03.persistencecontext;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class EntityLifeCycleTest {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {

        /* 설명. EntityManager가 생성될 때마다 고유의 새로운 영속성 컨텍스트(Entity를 관리하는 자바의 창고)가 생성된다. */
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    /* 설명.
     * 영속성 컨텍스트는 엔티티 매니저가 엔티티 객체를 저장하는 공간으로 엔티티 객체를 보관하고 관리한다.
     *  엔티티매니저가 생성될 때 하나의 영속성 컨텍스트가 할당된다.
     *
     * 설명.
     *   엔티티의 생명 주기
     *   비영속, 영속, 준영속, 삭제 상태
     * */

    @Test
    public void 비영속성_테스트() {
        Menu foundMenu = entityManager.find(Menu.class, 11);


        /* 설명. 비영속 상태의 newMenu */
        Menu newMenu = new Menu();
        newMenu.setMenuCode(foundMenu.getMenuCode());
        newMenu.setMenuName(foundMenu.getMenuName());
        newMenu.setMenuPrice(foundMenu.getMenuPrice());
        newMenu.setCategoryCode(foundMenu.getCategoryCode());
        newMenu.setOrderableStatus(foundMenu.getOrderableStatus());

        Assertions.assertFalse(foundMenu == newMenu); // 동등하지만 동일하지 않다.
    }

    @Test
    public void 영속성_테스트() {
        Menu foundMenu1 = entityManager.find(Menu.class, 11);
        Menu foundMenu2 = entityManager.find(Menu.class, 11);

        Assertions.assertTrue(foundMenu1 == foundMenu2);
    }

    @Test
    public void 영속성_객체_추가_테스트() {

        /* 설명.  이 예제에서는 @Id에 해당하는 속성에 직접 값을 넣기 위해 @GeneratedValue를 주석 처리할 것! */
        EntityTransaction transaction = entityManager.getTransaction();


        // service method (1)
        transaction.begin();

        Menu menuToRegist = new Menu();
        menuToRegist.setMenuCode(500);
        menuToRegist.setMenuName("수박죽");
        menuToRegist.setMenuPrice(100000);
        menuToRegist.setCategoryCode(10);
        menuToRegist.setOrderableStatus("Y");

        entityManager.persist(menuToRegist);
        Menu foundMenu = entityManager.find(Menu.class, 500);

        transaction.commit();

        Assertions.assertTrue(menuToRegist == foundMenu);

    }

    @Test
    public void 영속성_객체_추가_및_변경_테스트() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Menu menuToRegist = new Menu();
        menuToRegist.setMenuCode(501);
        menuToRegist.setMenuName("수박죽");
        menuToRegist.setMenuPrice(100000);
        menuToRegist.setCategoryCode(10);
        menuToRegist.setOrderableStatus("Y");

        entityManager.persist(menuToRegist);        // 여기서부터 menuToRegist는 '영속'상태가 됨
        menuToRegist.setMenuName("사과죽");

        Menu foundMenu = entityManager.find(Menu.class, 501);       // 디비에서 오는게 아니라 디비에 없는 친구니 맡아줘

        transaction.commit();

        assertEquals("사과죽", foundMenu.getMenuName());

    }

    // 관리되고 있다가 잠깐 떼진 상태 = 준영속상태
    @Test
    public void 준영속성_detach_테스트() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // find : 갖고 있으면 주고 없으면 영속상태 객체로 만들어서 줘 라는 의미!
        Menu foundMenu1 = entityManager.find(Menu.class, 11);
        Menu foundMenu2 = entityManager.find(Menu.class, 12);

        System.out.println("foundMenu1" + foundMenu1);      // select 1
        System.out.println("foundMenu2" + foundMenu2);      // select 1

        /* 설명.
         *  영속성 컨텍스트가 관리하던 엔티티 객체를 잠시 관리하지 않는 상태가 되게 한 것을 준영속 상태라고 한다.
         *  detach, clear, close가 준영속 상태를 만들기 위한 메소드이다.
         *
         *  설명
         *   준영속을 사용하는 이유?
         *   JPA에서 엔티티를 더 이상 영속성 컨텍스트에서 관리하지 않음을 의미하며, 특정 상황에서 성능 최적화나
         *   데이터 무결성 유지(데이터에 영향을 주지 않는다), 특정 작업 후 엔티티 변경 방지를 위해 사용된다. (백업 용도로 뺄 수 있다)
         *   */
        entityManager.detach(foundMenu2);

        foundMenu1.setMenuPrice(7000);  // 관리되는 상태  update O
        foundMenu1.setMenuPrice(7000);  // 관리되지 않는 상태 update x

        transaction.commit();

        assertEquals(7000, entityManager.find(Menu.class, 11).getMenuPrice());          // select 1
        assertNotEquals(7000, entityManager.find(Menu.class, 12).getMenuPrice());
    }

    @Test
    public void 준영속성_clear_close_테스트() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Menu foundMenu1 = entityManager.find(Menu.class, 11);
        Menu foundMenu2 = entityManager.find(Menu.class, 12);


//        entityManager.clear();    // 영속성 컨텍스트에 있는 모든 영속 상태의 엔티티를 준영속상태로 번경
        // 매니저사 폐점
        entityManager.close();      // 기존의 영속 상태의 엔티티들이 모두 준영속 상태로 변경 + 영속성 컨텍스트 파괴 (파업)

        // 매지저사 개업
        entityManager = entityManagerFactory.createEntityManager();

        // update가 날아가지 않아서 디비에 영향을 주지 않음.
        foundMenu1.setMenuPrice(7500);
        foundMenu2.setMenuPrice(7500);

        transaction.commit();

        assertNotEquals(7500, entityManager.find(Menu.class, 11).getMenuPrice());
        assertNotEquals(7500, entityManager.find(Menu.class, 12).getMenuPrice());

    }

    @Test
    public void 병합_merge_수정_테스트() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Menu menuToDetach = entityManager.find(Menu.class, 5);
        entityManager.clear();

        menuToDetach.setMenuName("수박죽");

        Menu refoundMenu = entityManager.find(Menu.class, 5);
        System.out.println("첫 번째 주소값: " + menuToDetach.hashCode());
        System.out.println("두 번째 주소값: " + refoundMenu.hashCode());

        entityManager.merge(menuToDetach);

        Menu managedMenu = entityManager.find(Menu.class, 5);

        transaction.commit();

        assertEquals("수박죽", managedMenu.getMenuName());

    }




}
