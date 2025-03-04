package com.ohgiraffers.section03.properties.subsection02.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class Application {
    public static void main(String[] args) {
        /* 설명.
        *   i18n 소프트웨어의 국제화(Internationalization에서 첫 글자인 I와 마지막 글자인 n 사이에
        *   알파벳 갯수가 18개)란?
        *    소프트 웨어를 국제화 하기 위해서는 처리해야 할 작업이 많이 있다.
        *   1. 언어, 지역별 번역
        *   2. OS/Platform별 인코딩
        *   3. 문자열 치환 방법 (한글, 영어 바이트 단위 다름, 파싱 방식)
        *   4. 국제화 UI(문자열 크기 변화, 폰트, 아이콘 등)
        *   5. 쓰기 방향의 차이
        *   6. 숫자, 공백, 화폐, 날짜, 주소, 측정 단위 등
        *   7. 타임존, 섬머타임 등 시각
        *   8. 문자열 정렬 방법
        *
        *   (+ Localization 문화, 유행, 행정, 법률 등을 고려하여 사용해야 함)
        *   설정 파일로 연습 예정
        *  */

        ApplicationContext context
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String error404MessageKR = context.getMessage("error.404", null, Locale.KOREA);
        String error500MessageKR =
                context.getMessage("error.500", new Object[]{"여러분", new java.util.Date()}
                        , Locale.KOREA);

        System.out.println("I18n error.404메세지: " + error404MessageKR);
        System.out.println("I18n error.500메세지: " + error500MessageKR);

        String error404MessageUS = context.getMessage("error.404", null, Locale.US);
        String error500MessageUS =
                context.getMessage("error.500", new Object[]{"you", new java.util.Date()}
                        , Locale.US);

        System.out.println("I18n error.404메세지: " + error404MessageUS);
        System.out.println("I18n error.500메세지: " + error500MessageUS);

    }
}
