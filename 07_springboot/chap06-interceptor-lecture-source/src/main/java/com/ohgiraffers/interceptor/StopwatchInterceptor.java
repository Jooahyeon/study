package com.ohgiraffers.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/* 설명.
*   1. bean을 다룰 수 있다.(필터와의 차이점)
*   2. 핸들러 메소드 직전/ 직후에 동작하여 전후 처리를 한다.
*       (forward 및 redirect 일지라도 매번 핸들러 메소드 실행 시 동작)
*   3. 이후에 진행될 핸들러 메소드의 동작 여부를 제어할 수 있다, (preHandle의 boolean반환형을 통해)
*   인터셉터를 사용하는 경우(목적)
*   : 로그인 체크, 권한 체크, 프로그램 실행 시간 계산 작업 로그 처리, 업로드 파일 사이즈 처리(리사이징), 로케일(지역) 설정 등
*
*  (+ 로그인 체크, 권한 체크 보안처리할 때 다시 배움/ 로그처리 -> 엑셀파일로 따로 저장해서 저장된 데이터를 통해 분석을 하는 형식으로 처리함
*   업로드 파일 사이즈 처리-> 그레이영역(서버가 해도 되고, 프론트에서 줄여서 해도 됨)
* */


@Component
public class StopwatchInterceptor implements HandlerInterceptor {
    InterceptorTestService testService;

    @Autowired
    public StopwatchInterceptor(InterceptorTestService testService) {
        this.testService = testService;
    }

    // 핸들러 전, boolean-> 얘가 뭐를 반환하느냐에 따라 핸들러의 동작을 제어할 수 있다.
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle 호출함..(핸들러 메소드 이전)");

        /* 설명. Service bean에 있는 메소드 호출 */
        testService.test();


        /* 설명. requestHeader에서 지역 추출 */
        Locale locale = request.getLocale();
        System.out.println("local = " + locale);
        if("ko_KR".equals(locale.toString())) System.out.println("한국인이시군요");


        // 로그 찍을 때 사용하는 인터셉터
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);


        /* 설명. 핸들러 인터셉트는 bean을 활용할 수 있으며 이후 핸들러 메소드 동작 여부를 반환형으로 제어할 수 있다. */
        // C-S-D 아무 계층을 안거칠 수 있다ㅡ
        return true;
    }

    //핸들러메소드 후
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandler를 호출함...(핸들러 메소드 이후)");
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();

        /* 설명. postHandledml ModelAndView는 Handler Method가 반환한 ModelAndView에 해당된다 */
        modelAndView.addObject("interval", endTime - startTime);


    }

    //핸들러 완성
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
