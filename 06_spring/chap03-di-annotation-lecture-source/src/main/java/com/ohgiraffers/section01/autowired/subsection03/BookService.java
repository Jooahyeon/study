package com.ohgiraffers.section01.autowired.subsection03;

import com.ohgiraffers.section01.Common.BookDAO;
import com.ohgiraffers.section01.Common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service(value = "bookServiceConstructor")
public class BookService {

    // +) final키워드 (bookDAO가 생성 된 후 활용 가능하고 변도이 없음을 고정할 때 final키워듯사용(생성자 주입에서만 가능한 final 키워드)

    private final BookDAO bookDAO;


    /* 설명.
    *   BookDAO 타입의 빈 객체를 생성자를 통해 주입 받는다.
    *   (@Autowired를 생성자에 작성하고 주입받을 타입의 bean을 매개변수로 작성한다.)
    *   (기본생성자 없음)
    *
    *  설명.
    *    생성자 주입의 이점
    *       1. 필드에 final키워드를 사용할 수 있다(오염방지)
    *       2. 순환 참조를 스프링 시작(컨테이너 생성 시)과 동시에 확인하고 에러를 발생시켜준다.
    *       3. field 주입 및 setter 주입의 단점을 보완
    *       (필드 주입은 간결하지만 남용할 수 있고 이후에 setter가 없이는 수정이 불가능하다)
    *       (setter 주입은 불변 객체를 만들고자 함에 있어 무넺가 발생할 수 있으며 객체의 변경이
    *       필요할 때만 setter를 추가하는 것이 맞다.(가급적 변경의 여지를 남기지 않아야 된다.))
    *       4. 테스트 코드 작성이 용이하다.(mock 객체 주입 용이)
    * */

    // +) DAO 방향성을 가지지만 많은 의존 관계를 맺고 있음 (final 예측이 가능->


    // +) 생성자 주입을하면 필드에 있는 애를 , 의존관계 주입된 애
    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> findAllBook() {
        return bookDAO.findAllBook();
    }

    public BookDTO findBookBySequence(int sequence) {
        return bookDAO.findBookBySequence(sequence);
    }


}
