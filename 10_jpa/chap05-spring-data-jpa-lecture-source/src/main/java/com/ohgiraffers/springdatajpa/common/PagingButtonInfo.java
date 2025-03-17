package com.ohgiraffers.springdatajpa.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
// 페이지 버튼을 화면에 표시하기 위한 세가지 재료를 지닌 객체
public class PagingButtonInfo {
    private int currentPage;        // 현재 보는 페이지 번호
    private int startPage;          //
    private int endPage;


}
