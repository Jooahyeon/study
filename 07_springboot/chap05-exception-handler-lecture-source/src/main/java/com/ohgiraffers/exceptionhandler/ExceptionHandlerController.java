package com.ohgiraffers.exceptionhandler;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class ExceptionHandlerController {
    @GetMapping("simple-null")
    public String simpleNullPointerExceptionTest() {

        if (true) {
            throw new NullPointerException();

        }
        return "/";
    }

    @GetMapping("simple-user")
    public String userExceptionTest() throws MemberRegistException {
        if (true) {
            throw new MemberRegistException("당신은 안돼");
        }

        return "/";
    }

    @GetMapping("annotation-null")
    public String nullPointerExceptionHandlerTest() {
        String str = null;
        str.charAt(0);

        return "/";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullPointExceptionHandler() {
        System.out.println("이 Controller에서 NullPointer 예외 발생 시 여기 오는지 확인");

        return "error/nullPointer";

    }

    @GetMapping("annotation-user")
    public String userExceptionHandlerTest() throws MemberRegistException {
        if (true) {
            throw new MemberRegistException("당신은 안된다고");
        }
        return "/";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(Model model) {
        System.out.println("이 controller에서 ~? ");

        model.addAttribute("exceptionMessage","당신은 안된다니까?");

        return "error/default";
    }

}
