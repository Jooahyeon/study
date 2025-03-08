package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller         // 얘가 달리면 콩이 된다
public class MethodMappingTestController {
    //    @RequestMapping(value = "/menu/regist")           // GET요청 뿐 아니라 다른 요청도 받음
    @RequestMapping(value = "/menu/regist", method = RequestMethod.GET)
    public String registMenu(Model model) {         // Model은 SSR기술에서 쓰는 것으로 응답할 페이지의 재료가 된다.(주머니 개념)
        // 모델 객체가 들어와서 모델객체를 attribute
        System.out.println("/menu/regist 경로의 GET 요청 받아보기");

        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출함...");
        // 내부적으로 포워딩(클라이언트 모르게 다른 곳에 위임하는 것)발생

        /* 설명. 핸들러 메소드에서 반환한 String은 응답 값이 아닌 view(html 파일 이름)이 된다. (View이름을 반환)*/
        return "mappingResult";         // view의 이름이 됨(SSR?)
    }

    @RequestMapping(value = "/menu/modify", method = RequestMethod.POST)
    public String modifyMenu(Model model) {
        model.addAttribute("message",  "POST방식의 메뉴 수정용 핸들러 메소드 호출함..");

        return "mappingResult";
    }

    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model) {
        model.addAttribute("message", "GET 방식의 메뉴 삭제용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model) {
        model.addAttribute("message", "POST 방식의 메뉴 삭제용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

 }
