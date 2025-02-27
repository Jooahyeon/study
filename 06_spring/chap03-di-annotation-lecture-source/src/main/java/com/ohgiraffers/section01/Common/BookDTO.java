package com.ohgiraffers.section01.Common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class BookDTO {
    private int sequence;
    private int isbn;
    private String title;
    private String author;
    private String publisher;
    private java.util.Date createDate;
}
