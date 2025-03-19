package com.ohgiraffers.mybatisspring.section01.factorybean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuServiceTest {
    // 메뉴서비스계층에서 필드 주입받음(객체를 전달받음)

    @Autowired
    private MenuService menuService;

    @DisplayName("주문 가능한 상태별 메뉴 조회 확인 테스트")
    @ParameterizedTest
    @ValueSource(strings={"Y","N"})
    void testFindAllMenus(String orderableStatus) {

        //단정문사용
//        assertDoesNotThrow 람다식 상에서 에러가 발생하지 않으면 초록불!
        // 이번 프로젝트할 때 주요 기능 몇가지의 메소드만 테스트진행해볼 것(간단하게 한두개만 넣어둘 것)
        Assertions.assertDoesNotThrow(
                () -> {
                    List<MenuDTO> menus = menuService.fingAllMenuByOrderableStatus(orderableStatus);
                    menus.forEach(System.out::println);
                }
        );
    }
}