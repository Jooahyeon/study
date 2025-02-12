package com.ohgiraffers.section03.map.run;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Application4 {
    public static void main(String[] args) {

        /* 수업목표. properties에 대해 이해하고 활용할 수 있다.*/
        /* 설명
        *   properties란
        *   HashMap과 거의 유사하지만 key와 value 모두를 string으로만 사용할 수 있는
        *   자료구조이다.(제네릭을 별도로 요구x)
        *   주로 설정과 관련된 파일과의 입출력에 사용된다(store, load 등)
        *
        *   설정파일을 만드는 이유 -> 키=value 형태로 저장됨 , java를 jar로 바꾸는데 오래걸림
        *   but, properties는 오래 걸리지 않음, value만 설정 (외부파일로 빼내야 영향을 주지 않음)*/
        // 1, 수정 용이함 2, 비개발자도 수정할 수 있도록

        Properties prop = new Properties();

        prop.setProperty("driver", "oracle.jdbc.driver.OravleDriver");
        prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe");
        prop.setProperty("user", "swcamp");
        prop.setProperty("password", "swcamp");

        System.out.println("prop = " + prop);

        //파일출력은 트라이캐치 주로 사용
        //확장가능한마크업랭기지 태그를 맘대로 쓸 수 있음
        // 시작태그   콘텐츠    종료태크 텍스트보다 가독성이 좋음
        // 아래 파일 출력을 내보낸 것
        try {
            prop.store(new FileOutputStream("driver.dat"), "jdbc driver");
            prop.storeToXML(new FileOutputStream("driver.xml"), "jdbc driver xml version");
        } catch (IOException e) {
            throw new RuntimeException();
        }

        /*설명. 방금 출력으로 내보낸 파일을 읽어와서 새로운 Properties에 담아보자. */
        Properties prop2 = new Properties();
        System.out.println("읽어오기 전: " + prop2);

        try {
//            prop2.load(new FileInputStream("driver.dat"));
            prop2.load(new FileInputStream("driver.xml"));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        // xml 파일로 입출력 가능
        // 키를 통해 불러올 수 있음
        // 키를 set으로 보내고 iterator로 돌려서 키값을 하나씩 꺼낼수도 있음
        System.out.println("===== 읽어와 담긴 값 =====");
        System.out.println("드라이버: " + prop2.getProperty("driver"));
        System.out.println("경로: " + prop2.getProperty("url"));
        System.out.println("아이디: " + prop2.getProperty("user"));
        System.out.println("패스워드: " + prop2.getProperty("password"));

    }
}
