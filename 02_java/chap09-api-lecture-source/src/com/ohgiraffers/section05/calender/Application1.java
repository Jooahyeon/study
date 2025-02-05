package com.ohgiraffers.section05.calender;

import java.text.SimpleDateFormat;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. java.util.Date 클래스 사용법을 이해하고 활용할 수 있다.*/
        java.util.Date today = new java.util.Date();        // 시스템의 현재 시간을 가진 객체 생성
        System.out.println("today = " + today);

        System.out.println("long 타임 시간: " + today.getTime());
        System.out.println("long 타임 시간을 활용한 Date: " + new java.util.Date(0L));
        System.out.println("long 타임 시간을 활용한 Date: " + new java.util.Date(today.getTime()));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E요일");
        // 개발자가 날짜도 가공처리 해줘야해
        String todayFormat = sdf.format(today);
        System.out.println("todayFormat = " + todayFormat);

        /*설명. java.util.Date -> java.sql.Date _DB의 Date형과 자바와 맞춰주기 위해/DB에 맞는 포맷으로 변경 */
        java.util.Date today2 = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(today2.getTime());

        /*설명. java.sql.Date -> java.util.Date -> DB에서 자바로 */
        java.util.Date today3 = sqlDate;                // 다형성 적용 (sql.Date는 util.Date에 상속됨)
    }
}
