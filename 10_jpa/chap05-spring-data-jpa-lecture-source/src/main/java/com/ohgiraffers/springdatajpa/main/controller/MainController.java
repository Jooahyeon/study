package com.ohgiraffers.springdatajpa.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 공용인 것
@Controller
public class MainController {
    @GetMapping(value = {"/", "/main"})
    public String main() {
        return "main/main";
    }
}
