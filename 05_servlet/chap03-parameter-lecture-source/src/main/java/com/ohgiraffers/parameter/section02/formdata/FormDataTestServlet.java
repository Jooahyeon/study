package com.ohgiraffers.parameter.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;


// url에 노출되지 않는게 post
@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 설명. tomcat 9버전 이하는 post 방식 요청일 때 한글이 깨지지 않으려면 UTF-8로 인코딩 서렂ㅇ해 주어야 한다. */
        // 우리꺼는 10버전임!
//        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        System.out.println("name = " + name);

        // Key를 순회하고 싶을 때!
        /* 설명. parameter들을 한번에 순회하며 확인하고 싶을 때 (키 값)
        * dopost를 오버라이딩 해서 뽑으면 됨.
        * 경우에 따라 파싱해서 자료형을 맞춰주고 꺼낼수도 있음. */
        Enumeration<String> keyNames = req.getParameterNames();
        while (keyNames.hasMoreElements()) {
            System.out.println(keyNames.nextElement());
        }
    }
}
