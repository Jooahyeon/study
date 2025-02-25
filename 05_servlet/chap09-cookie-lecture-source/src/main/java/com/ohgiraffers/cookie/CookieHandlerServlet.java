package com.ohgiraffers.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 바디부에 담겨서 url에 노출되지 않음.
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("이름 = " + firstName);
        System.out.println("성 = " + lastName);

        /* 설명.
        *   쿠키(클라이언트의 브라우저에 저장)를 생성해서 전달하는 방법
        *   1. 쿠키 인스턴스를 생성한다.
        *   2. 해당 쿠키의 만료시간을 설정한다.
        *   3. 응답 헤더에 쿠키를 담는다.
        *   4. 응답한다.
        * */

        //사용자가 전달한 것을 꺼내서 cookie로 설정(key, value형태)
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        firstNameCookie.setMaxAge(60 * 60 * 24);        // 초 단위로 생성, 하루의 만료시간을 가지도록 작성
        lastNameCookie.setMaxAge(60 * 60 * 12);         // 12시간

        // response헤더의 만료시간이 설정된 두개의 쿠키를 담는 것
        resp.addCookie(firstNameCookie);
        resp.addCookie(lastNameCookie);

        // 응답방식 중 redirect -> 기존 response는 소멸되고 새로운 response헤더에 담김
        resp.sendRedirect("redirect");


    }
}
