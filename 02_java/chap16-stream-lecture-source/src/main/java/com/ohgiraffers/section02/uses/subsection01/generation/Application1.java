package com.ohgiraffers.section02.uses.subsection01.generation;

import java.util.Arrays;
import java.util.stream.Stream;


    public class Application1 {
        public static void main(String[] args) {
            /* 수업목표. 배열이나 컬렉션은 스트림을 이용할 수 있고 이를 이해해서 활용할 수 있다, */
            //배열을 스트림 활용해서 foreach돌리는 것
            String[] sArr = new String[]{"java", "mariaDB", "jdbc"};

            /* 목차. 1. 배열로 Stream 생성 */
            /* 설명. Arrays.stream(배열): 배열 자료형을 Stream 자료형으로 반환*/
            System.out.println("==== 배열로 스트림 생성 ====");
            Stream<String> stringStream1 = Arrays.stream(sArr);


            /*설명. forEach는 자신의 매개변수에 정의된 람다식의 매개변수로 stream의 각 요소들을 자동으로 넘기며 순회
               (매번 요소마다 람다식 실행)*/
            //아래와 동일함 strStream1.foreach (x -> System.out.println(x));
            //        stringStream1.forEach(System.out::println);

            Arrays.stream(sArr).forEach(System.out::println);               //결론 (완전축약형 현업에서 많을듯)
            System.out.println();

            /* 설명. Stream으로 관리되는 요소들은 원하는 갯수만큼 반복할 수 있다. */
            Stream<String> stringStream2 = Arrays.stream(sArr, 0, 2);
            stringStream2.forEach(System.out::println);

            /* 설명.
            *   Builder를 활용한 스트림 생성
            *   builder는 static<T>로 되어 있는 메소드이며, 호출 시 파라미터를 메소드 호출 방식으로 전달한다. */

            System.out.println("==== Builder로 스트림 생성 ====");
            Stream<String> builderStream = Stream.<String>builder()             //배열 없이도 빌더 사용하면 가능,
                    // <>안 형태를 맞춰줘야해
                                                  .add("홍길동")
                                                  .add("유관순")
                                                  .add("윤봉길")
                                                  .build();

            builderStream.forEach(System.out::println);

//            Stream.<String>builder.add("홍길동").add("유관순").add("윤봉길").build().forEach(System.out::println);
            //한줄로도 가능함



        }

    }

