package com.ohgiraffers.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet
public class ReceiveInformationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);

        /* 설명.
        *   이 부분에서는 id와 pw에 해당하는 User의 정보를 DB까지 가서 select하고 확인하는
        *   비즈니스 로직(BL)이 수행되어야 한다(그 결과는 회원의 정보를 조회해 옴)
        *   우리는 제대로 조회되었다는 가정 하에 'XXX님 환경합니다.'와 같은 메시지를 출력하는
        *   화면을 만들어 응답해 보자.
        * */

        req.setAttribute("userName", "홍길동");   //사용자의 입력값 및 디비에 있는 내용까지 req에 담겨있는 것
        // -> 그림 잘그리는 서블릿에 위임할 것
        RequestDispatcher rd = req.getRequestDispatcher("print");
        rd.forward(req, resp);


    }
}
