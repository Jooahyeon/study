package com.ohgiraffers.section03.grammer;

import java.util.EnumSet;
import java.util.Iterator;

public class Application {
    public static void main(String[] args) {
        UserRole1 admin = UserRole1.ADMIN;
        System.out.println(admin.name());
        System.out.println(admin.getNameTolowerCase());

        UserRole2 consumer = UserRole2.CONSUMER;
        System.out.println(consumer.ordinal() + ", " + consumer.name()
                            + ", " + consumer.getDESCRIPTION());            //DB로 업데이트문 넣을 때 가능

        /*설명. Set의 개념으로 활용할 수도 있다.(feat.Iterator)
        *  어렵다면 vlaues 쓰면 된다 다만, 현업에서 이해할 수 있어야하니 알아둘 것 */
        System.out.println("Set으로 바꿔 반복자를 활용해 보자,");
        EnumSet<UserRole2> roles = EnumSet.allOf(UserRole2.class);      //유저2타입의 타입
        Iterator<UserRole2> iter = roles.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().name());
        }
    }
}
