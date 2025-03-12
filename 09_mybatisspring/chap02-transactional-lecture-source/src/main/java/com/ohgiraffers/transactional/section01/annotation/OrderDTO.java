package com.ohgiraffers.transactional.section01.annotation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

// 전 계층을 왔다갔다ㅡ 하는 놈(메뉴 엔티티랑은 다름)
public class OrderDTO {

    // 디비가 바차형이여도 서버에서는 시간을 저장해야하기 때문에 추후 스트링형태로 바꾸고 현재시간을 뽑기 좋아서 얘로 쓰고 스트링 형태로 포맷해서 사용하기도 함
    // 컨트롤러가 시간을 넘겨줬다 가정
    private LocalDate orderDate;                    // 서버의 현재 날짜
    private LocalTime orderTime;                    // 서버의 현재 시간

    // 컨트롤러가 값을 던져줬다 가정
    private List<OrderMenuDTO> orderMenus;          // 한 건의 주문에 고객이 주문한 메뉴들 (오더에 오더 메뉴들이 들어있는 것)

    public OrderDTO() {
    }

    public OrderDTO(LocalDate orderDate, LocalTime orderTime, List<OrderMenuDTO> orderMenus) {
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.orderMenus = orderMenus;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }

    public List<OrderMenuDTO> getOrderMenus() {
        return orderMenus;
    }

    public void setOrderMenus(List<OrderMenuDTO> orderMenus) {
        this.orderMenus = orderMenus;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderDate=" + orderDate +
                ", orderTime=" + orderTime +
                ", orderMenus=" + orderMenus +
                '}';
    }
}
