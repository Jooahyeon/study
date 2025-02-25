package com.ohgiraffers.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// 이게 변형된 게 JSP
@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder responseText = new StringBuilder(); // 화면에 문자열 나올 예정
        responseText.append("<!DOCTYPE html>\n")
                   .append("<html>\n")
                   .append("<head>\n")
                   .append("</head>\n")
                   .append("<body>\n")
                   .append("<h1>servlet response</h1>\n")
                   .append("</body>\n")
                   .append("</html>\n");

        /* 설명. MINE 타입과 인코딩 설정해 주어야 한다. 다만 우린 jakarta는 굳이 해주지 않아도 된다. */
        // 이걸 알려준 상태로 길을 만들어야 적용이 됨(순서 중요)
        // jakarta
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html; charset=UTF-8");

        //순서
        PrintWriter out = resp.getWriter();
        out.print(responseText);
        out.flush();
        out.close();
    }
}
