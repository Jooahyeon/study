package com.ohgiraffers.section03.map.run;

import com.ohgiraffers.section01.list.dto.BookDTO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. Map의 자료구조에 대해 이해하고 HashMap을 이용할 수 있다. */
        Map<Object, Object> hMap = new HashMap<>();
        hMap.put("one", new java.util.Date());
        hMap.put(12, "red apple");
        hMap.put(33, 123);

//        System.out.println("키가 \"one\"인 value 값 : " + hMap.get("one"));
        /*설명. Map은 key를 통해 value를 뽑는 것이 기본적이며 key는 객체의 동등비교(e,h)를 통해 확인된다.*/
        System.out.println("키가 \"one\"인 value 값 : " + hMap.get(new String("one")));
        // key가 객체의 동등비교로 key가 같냐?! 라고 비교하는 것
        // key를 객체로 생성 후 오버라이딩 해야 중복되는 경우 제외함.
        System.out.println(hMap);
        System.out.println();
        //key가 더 커도 가능 (key 오버라이딩 안된 상태_동등비교가 안되서 같지 않은걸로 인식함)
        //그럼 뭫야해?! BookDTO가서 (e,h)하면 된다

        /*목차. 1. key가 중복되는 경우*/
        /*설명. 우리가 만든 객체도 key로 사용할 수 있으며 이때 해당 객체는 e, h가 반드시 오버라이딩 되어 있어야 한다. */
        hMap.put(new BookDTO(1, "홍길동전", "허균", 50000), 1);
        hMap.put(new BookDTO(2, "홍길동전", "허균", 50000), 2);
        System.out.println("BookDTO 객체를 활용한 key와 vlaue 쌍을 두개 추가 후 : "+ hMap);

        /*목차. 2. value가 중복되는 경우 */
        // value는 중복되어도 됨
        // key는 unique해야 함
        hMap.put(44, 123);
        System.out.println("value가 중복되는 key와 value 쌍을 추가 후: " + hMap);

        System.out.println();

        /*설명. Map을 활용해 보자_반복을 할 수 없어*/
        // 1. key를 set으로 바꿔서 Iterator를 씀..(key를 반복으로 돌림)
        Map<String, String> hMap2 = new HashMap<>();
        hMap2.put("one", "java 17");
        hMap2.put("two", "mariaDB 10");
        hMap2.put("three", "servlet/jsp");
        hMap2.put("four", "springboot 3.0");
        hMap2.put("five", "vue");

        System.out.println("hMap = " + hMap2);

        System.out.println();
        /*설명. Map에 담긴 값을 순회해서 확인하는 방법 (두개중에 하나는 알아라)*/
        /*목차. 1. keySet()을 활용해 key를 Set으로 바꾸고 iterator를 돌리는 방법
        *  메모리를 덜 차지함! 아래보다! */
        Set<String> keys = hMap2.keySet();
        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println("key = " + key + ", value = " + hMap2.get(key));
        }

        /* 목차. 2. entrySet()을 활용하는 방법(key와 value를 묶은 Entry타입(하나의 객체로)을 통해 key없이도 value만 추출 가능)
        *   value를 가져오려면 get으로 뽑아야 함 */
        // key가 없어도 value만 뽑을 수 있음
        Set<Map.Entry<String, String>> set = hMap2.entrySet();              //innerclass형태(맵안에 entry가 있음)
        Iterator<Map.Entry<String, String>> iter2 = set.iterator();
        while(iter2.hasNext()) {
            Map.Entry<String, String> entry = iter2.next();
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());

        }

    }
}
