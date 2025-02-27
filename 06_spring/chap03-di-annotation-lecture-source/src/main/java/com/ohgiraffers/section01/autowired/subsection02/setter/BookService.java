package com.ohgiraffers.section01.autowired.subsection02.setter;

import com.ohgiraffers.section01.Common.BookDAO;
import com.ohgiraffers.section01.Common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Autowired  필드 생성자(추천) 세터 세 곳에 붙일 수 있움

@Service("bookServiceSetter")                //+) @component 의미를지님, 서비스 자체는 가독성 측면(부가기능은 없어)
public class BookService {

    public BookDAO bookDAO;  // ComponentScan 범위 안에 BookDAO타입의 bean이 존재

    public BookService() {

    }

    @Autowired     // setter를 통한 주입(세터를 나중에 호출해줌)
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
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
