package com.ohgiraffers.section01.Common;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository  // 콩이 되도록 한 후 주입(의존성 주입이 된 것)
public class BookDAOImpl implements BookDAO{

    private Map<Integer, BookDTO> booklist;

    /* 설명. JDBC를 활용한 실제 */
    public BookDAOImpl() {
        booklist = new HashMap<>();
        booklist.put(1, new BookDTO(1, 123456, "자바의 정석",
                "남궁석", "도우출판", new java.util.Date()));

        booklist.put(2, new BookDTO(2, 222345, "칭찬은 고래도 춤추게 한다.",
                "고래", "고래출판", new java.util.Date()));
    }

    @Override
    public List<BookDTO> findAllBook() {

    /* 설명.  Map을 List형태로 변환 */
        return new ArrayList<>(booklist.values());
    }

    @Override
    public BookDTO findBookBySequence(int sequence) {
        return booklist.get(sequence);
    }


}
