package com.ohgiraffers.chap01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

// + 모든 필터를 거치라는 것 /first/*
/* 설명. /first 이후 경로는 어떤 것이든 지금의 FirstFilter를 거치는 요청 경로가 된다. */

/* 설명.
*   @WebFilter라는 어노테이션을 통해 필터 설정을 할 수 있지만 필터의 동작 순서를 원하는대로
*   동작하게 하기 위해서는 Servlet에서는 wev.xml을 활용한 xml방식의 설정을 통해서만 바꿔줄 수 있다.
*   (필터의 동작 순서는 web.xml에 작성한 filter mapping의 순서에 따라 동작한다.)*/

// +) url을 없앤 것
//@WebFilter(filterName = "FirstFilter", urlPatterns = "/first/*")
@WebFilter(filterName = "firstFilter")
public class FirstFilter implements Filter {

    public FirstFilter() {
        System.out.println("FirstFilter 인스턴스 생성!");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter의 init 호출!");
    }

    // +) filterChain : 다음 필터가 있다면 다음 필터로 갈 수 있다는 의미
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FirstFilter의 doFilter 호출!");

        // +) 위에는 전처리 밑에는 후처리  / 암호화 처리를 filter에서 주로 많이 함
        // +) 해당 로직이 실행되는데 걸리는 시간도 필터를 통해 알 수 있음
        /* 설명. Filterchain에서 제공하는 doFilter는 다음 필터 또는 서블릿으로 진행하라는 의미이다. */
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("서블릿 다녀온 후");
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter의 destroy 호출! ");
    }
}
