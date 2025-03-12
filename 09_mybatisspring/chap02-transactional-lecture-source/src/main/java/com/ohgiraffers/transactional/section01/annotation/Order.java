package com.ohgiraffers.transactional.section01.annotation;

import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
    private int orderCode;
    private String orderDate;
    private String orderTime;
    private int totalOrederPrice;

    public Order() {
    }

    // 디티오와 엔티티는 다를 수 있다
    public Order(LocalDate orderDate, LocalTime orderTime, int totalOrederPrice) {

    }

    public Order(String orderDate, String orderTime, int totalOrederPrice) {
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.totalOrederPrice = totalOrederPrice;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public int getTotalOrederPrice() {
        return totalOrederPrice;
    }

    public void setTotalOrederPrice(int totalOrederPrice) {
        this.totalOrederPrice = totalOrederPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderCode=" + orderCode +
                ", orderDate='" + orderDate + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", totalOrederPrice=" + totalOrederPrice +
                '}';
    }
}
