package com.ohgiraffers.section02.delete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        System.out.println("attribute 만료 전 firstName: "
                            + session.getAttribute("firstName"));
        System.out.println("attribute 만료 전 lastName: "
                            + session.getAttribute("lastName"));

       // + 사물함 비우는 것  -> 에러 패키지 따로 안만들면 500번 에러 발생하여 무효화시킴
        session.invalidate();       //HttpSession 객체의 Attribute 값들을 무효화(로그아웃 개념으로 많이 쓰게 된다)

        /* 설명. session이 무효화되어 attribute를 가져올 수 없게 된다.(가져오려고 하면 500에러 발생)*/
        System.out.println("attribute 무효화 후 firstName: "
                + session.getAttribute("firstName"));
        System.out.println("attribute 무효화 후 lastName: "
                + session.getAttribute("lastName"));
    }
}
