package com.ohgiraffers.chap01;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/* 설명.
 *   @WebFilter라는 어노테이션을 통해 필터 설정을 할 수 있지만 필터의 동작 순서를 원하는대로
 *   동작하게 하기 위해서는 Servlet에서는 wev.xml을 활용한 xml방식의 설정을 통해서만 바꿔줄 수 있다.
 *   (필터의 동작 순서는 web.xml에 작성한 filter mapping의 순서에 따라 동작한다.)*/

//@WebFilter("/*") // 모든 요청에 대해 처리되는 필터를 만들고 싶을 때
//@WebFilter(filterName = "secondFilter", urlPatterns = "/first/*")
@WebFilter(filterName = "secondFilter")
public class secondFilter implements Filter {
    public secondFilter() {
        System.out.println("secondFilter 인스턴스 생성!");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("secondFilter의 init 호출!");
    }

    // +) filterChain : 다음 필터가 있다면 다음 필터로 갈 수 있다는 의미
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("secondFilter의 doFilter 호출!");

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
