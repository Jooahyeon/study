package com.ohgiraffers.section03.annotationconfig.subsection03;

import org.springframework.stereotype.Service;

@Service(value = "bookServiceConstructor")
public class BookService {
    private BookDAO bookDAO;
}
