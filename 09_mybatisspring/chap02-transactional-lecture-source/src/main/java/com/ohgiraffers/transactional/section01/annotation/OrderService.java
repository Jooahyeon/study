package com.ohgiraffers.transactional.section01.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
// 두 도메인에 트랜잭션 하나가 발생


@Service
// 얘 다음에 주문, 메뉴 -> DAO가 두개인 개념 (다른 도메인과의 영향이 있는 경우(policy)) 한 트랜잭션 안에서 두가지 범위를 건드리는 것
public class OrderService {

    /* 설명. Order 도메인과 Menu 도메인과 두개를 하나의 Service에서 트랜잭션 상 쓰는 경우 상정*/
    private OrderMapper orderMapper;
    private MenuMapper menuMapper;

    // 도메인 단위가 테이블 단위가 아님...
    @Autowired
    public OrderService(OrderMapper orderMapper, MenuMapper menuMapper) {
        this.orderMapper = orderMapper;
        this.menuMapper = menuMapper;
    }


    /* 설명. Service 계층의 메소드가 DML 작업용 트랜잭션이면 @Transactional을 추가한다. */
    @Transactional
    // 서비스에 DML 작업을 할 때는 달아줘야 함아아암
    // 해당 메소드가 진행됨에 따라 커넥션 객체가 할당(내장 톰캣에서) 후 트랜잭션 어노테이션을 만남 아무일도 진행되지 않으면 자동으로 커넥션으로 날라감(커밋)
    // 메소드가 한번이라도 에러가 나면 자동 롤백
    // OrderDTO안에 order와 ordermenu 두개의 도메인이 들어가 있는 것
    // 서비스계층 -> dto와 엔티티를 (교차)스위칭하는 역할도 함
    // 사용자의 값을 담아 디티오로 왔다가 엔티티가 디티오(디티오-> 엔티티)
    public void registNewOrder(OrderDTO orderInfo) {

        /* 설명. 1. 주문된 메뉴 코드만 추출(DTO에서) _코드 혹은 단가 추출(주머니에 담아 리스트로 뽑은 것) */
//        List<Integer> menuCode = new ArrayList<>();
//        List<OrderMenuDTO> orderMenus = orderInfo.getOrderMenus();
//        for (OrderMenuDTO orderMenu : orderMenus) {
//            menuCode.add(orderMenu.getMenuCode());
//        }
        // 왜이렇게 해? 메뉴에 대한 자세한 정보가 없기에 단가를 아니까 조회만 해온 것
        List<Integer> menuCodes = orderInfo.getOrderMenus()
                .stream()
                .map(OrderMenuDTO::getMenuCode)
                .collect(Collectors.toList());

        Map<String, List<Integer>> map = new HashMap<>();
        map.put("menuCodes", menuCodes);

        /* 설명. 2. 주문한 메뉴 별로 Menu엔티티에 담아서 조회(select)해 오기(부가적인 메뉴의 정보 추출) */
        List<Menu> menus = menuMapper.selectMenuByMenuCodes(map);
//        menus.forEach(System.out::println);


        /* 설명. 3. 이 주문건에 대한 주문 총 합계를 계산 */
        int totalOrderPrice = calcTotalPrice(orderInfo.getOrderMenus(), menus);

        /* 설명. 4. 1부터 3까지 하면 tbl_order 테이블에 추가(insert) */

        /* 설명. 4-1. OrderDTO -> Order */

        Order order = new Order(orderInfo.getOrderDate(), orderInfo.getOrderTime(), totalOrderPrice);

        /* 설명. 4-2. Order로 insert (selectKey를 통해 insert하고 나서의 주문번호를 orderCode에 담긴 상태로*/

        /* 설명. 5. tbl_order_menu 테이블에도 주문한 메뉴 갯수만큼 메뉴를 추가(insert) */

        /* 설명. 5-1. OrderDTO -> List<OrderMenuDTO> -> List<OrderMenu> */


    }

    private int calcTotalPrice(List<OrderMenuDTO> orderMenus, List<Menu> menus) {
        int totalPrice = 0;

        int orderMenuSize = orderMenus.size();
        for (int i = 0; i <orderMenuSize; i++) {                // 사용자가 주문한 메뉴 수만큼 반복
            OrderMenuDTO orderMenu = orderMenus.get(i);         // 메뉴 수량 추출을 위해
            Menu menu = menus.get(i);                           // 메뉴 단가 추출을 위해
            totalPrice += orderMenu.getOrderAmount() * menu.getMenuPrice();
        }
        return totalPrice;
    }


}
