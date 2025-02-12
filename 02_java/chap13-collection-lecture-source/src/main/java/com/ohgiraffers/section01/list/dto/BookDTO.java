package com.ohgiraffers.section01.list.dto;

import java.awt.print.Book;
import java.util.Objects;

public class BookDTO implements Comparable<BookDTO> {
    // 하나만 가능하나 보완으로 다른게 있음.이름이 기억안남
    private int number;
    private String title;
    private String author;
    private int price;

    public BookDTO() {
    }

    public BookDTO(int number, String title, String author, int price) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    /*설명.
    *   우리가 원하는 필드의 오름차순 또는 내림차순을 할 수 있다.
    *   필드가 n개면 총 (n * 2)가지 정렬 기준을 가질 수 있다.(각각 ASC 또는 DESC)
    *   정렬은 CompareTo() 메소드가 변환하는 int형의 부호에 따라 정해지게 되므로 오름차순과 내림차순은
    *   부호만 달리 되도록 하면 된다.
    *   (해당 필드가 String형인 경우는 String에 정의 된 compareTo() 메소드를 활용한다.)
    * */

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookDTO bookDTO = (BookDTO) o;
        return getPrice() == bookDTO.getPrice() && Objects.equals(getTitle(), bookDTO.getTitle()) && Objects.equals(getAuthor(), bookDTO.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAuthor(), getPrice());
    }

    @Override
    public int compareTo(BookDTO o) {
        //String 문자열 비교를 int형으로 오버라이드해서 바꾼 것
        // 제네릭을 안걸면 object로 되어있어 매번 다운캐스팅 해야 함
       /* 설명. 가격에 대한 오름차순(기준)*/
//        return this.price - o.price;


        /* 설명. 가격에 대한 내림차순 (-로 부호가 바뀜)*/
//        return  (o.price - this.price);
//        return - (this.price - o.price);

        /* 설명. 책 제목에 대한 오름차순(기준) */
        return this.title.compareTo(o.title);      //문자열로 비교(아스키소드 활용하여!)

        /* 설명. 책 제목에 대한 내림차순 */
//        return -this.title.compareTo(o.title);
//        return o.title.compareTo(this.title);
    }
}
