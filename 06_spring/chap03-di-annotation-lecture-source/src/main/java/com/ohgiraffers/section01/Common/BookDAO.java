package com.ohgiraffers.section01.Common;

import java.util.List;

public interface BookDAO {

    List<BookDTO> findAllBook();

    BookDTO findBookBySequence(int sequence);
}
