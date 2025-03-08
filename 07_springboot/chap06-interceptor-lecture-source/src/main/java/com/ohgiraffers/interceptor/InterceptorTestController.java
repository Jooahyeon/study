package com.ohgiraffers.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterceptorTestController {
    @GetMapping("stopwatch")
    public String handlerMethod() throws InterruptedException {
        System.out.println("핸들러 메소드 호출함..");

        // 컨트롤러 안에서 디비 찍고 오는 시간을 나타낸 것, MB에서 다시 해볼 예정임'
        Thread.sleep(1000);

        return "result";
    }
}
