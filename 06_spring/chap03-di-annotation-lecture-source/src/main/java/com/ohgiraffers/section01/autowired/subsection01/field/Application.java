package com.ohgiraffers.section01.autowired.subsection01.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        /* 설명. ComponentScan 개념의 basePackage 문자열을 넣으면 따로 설정 파일 없이 ComponentScan이 적용됨 _ 외울필요 놉*/
//        "com.ohgiraffers.section01" 얘가 context에 담겨 콩이 될거임
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

//         콩이 나옴! 확인ㅂ
//        System.out.println(context.getBean("bookService"));

            BookService bookService = context.getBean(BookService.class);

            /* 설명. List<BookDTO>가 반환되어 오면 stream 문법을 순회하며 확인 */
        // 서비스의 DAO가 의존성 주입이 되었다.
        bookService.findAllBook().stream().forEach(System.out::println);
//        foreach로 반환형이 없는 람다식으로 활용 ::


        /* 설명. 도서 번호로 검색 후 출력 확인 */
        // field에 DI
        System.out.println("1번 책 : " + bookService.findBookBySequence(1));
        System.out.println("2번 책 : " + bookService.findBookBySequence(2));

    }
}
