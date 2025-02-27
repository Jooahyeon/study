package com.ohgiraffers.section01.autowired.subsection01.field;


import com.ohgiraffers.section01.Common.BookDAO;
import com.ohgiraffers.section01.Common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

@Service                //+) @component 의미를지님, 서비스 자체는 가독성 측면(부가기능은 없어)
public class BookService {

    /* 설명.
     *   아래의 세 가지는 ComponentSacn 범위 안에 어노테이션이 달렸을 때 유효하다.
     *   1. @Service에 의해서 BookService 타입의 bookService id의 bean이 관리된다.
     *   2. BookDAOImpl에 있는 @Repository에 의해서 bookDAOImple id의 bean이 관리된다 (BookDAO타입이기도 하다)
     *   3. @Autowired에 의해서 bookDAO 타입의 bean이 BookService의 필드인 bookDAO 필드에 주입된다(대입된다)
     *   (= 필드 주입)
     * */

    // +) 객체를 새로 만들지 않고 의존성 주입이 된 것(자동으로 연결을 해준 것, auto-wired)
    // +) t서비스 입장에서는 BookDAOImpl가 어떻게 구현했는지는 모름, 호출하면 끝나는 것
    @Autowired
    public BookDAO bookDAO;  // ComponentScan 범위 안에 BookDAO타입의 bean이 존재

    public BookService() {

    }

    /* 설명. 도서 목록 전체 조회*/
    public List<BookDTO> findAllBook() {
        return bookDAO.findAllBook();
    }

    /* 설명. 도서 번호로 도서 조회 */
    public BookDTO findBookBySequence(int sequence) {
        return bookDAO.findBookBySequence(sequence);
    }




}
