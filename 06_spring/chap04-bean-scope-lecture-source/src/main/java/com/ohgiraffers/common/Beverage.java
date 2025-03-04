package com.ohgiraffers.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString

public class Beverage extends Product {
    private int capacity;           // 용량(ml)

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "capacity=" + capacity +
                '}';
    }
}

