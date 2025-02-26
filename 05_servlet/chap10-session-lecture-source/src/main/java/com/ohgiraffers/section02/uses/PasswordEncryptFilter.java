package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;

import java.io.IOException;

public class PasswordEncryptFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /* 설명. 기존의 Request 객체가 아닌 우리가 getParameter()를 재정의한 Request 객체로 교체한다. */
    }
}
