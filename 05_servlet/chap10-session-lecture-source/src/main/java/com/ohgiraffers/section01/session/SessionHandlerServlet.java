package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        /* 설명.
        *   요청이 서블릿으로 돌아올 때 HttpServletRequestdpsms JSESSIONID(사물함키)라는 값이 Header에 같이
        *   포함되어 넘어온다. 그때 해당 JSESSIONT에 맞는 HttpSession 객체를 생성해서 해당 사용자를
        *   위한 전용 저장 공간을 제공하게 된다.
        *   (요청을 보낸 사람 전용 Session 저장 공간 생성)
        * */

        HttpSession session = req.getSession();
        System.out.println("session 객체의 default 만료 시간(초):" +
                + session.getMaxInactiveInterval());

        session.setMaxInactiveInterval(60 * 10);        //10분으로 수정
        System.out.println("session 객체의 수정 후 만료 시간(초): "
                + session.getMaxInactiveInterval());
        System.out.println("session id(해당 session JSESSIONID): "
                + session.getId());

        session.setAttribute("firstName" , firstName);
        session.setAttribute("lastName" , lastName);

        resp.sendRedirect("redirect");


    }
}
