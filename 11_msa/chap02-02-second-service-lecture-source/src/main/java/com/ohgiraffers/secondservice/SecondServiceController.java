package com.ohgiraffers.secondservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class SecondServiceController {
    // 환경 설정 값을 불러오는 방법 중 하나 : environment
    // local.server.port : 동적으로 할당된 실제 서버의 포트를 반환해줌
    private Environment env;

    // 의존성도 주입해줘야해!
    @Autowired
    public SecondServiceController(Environment env) {
        this.env = env;
    }


    @GetMapping("/health")
    public String healthCheck() {
        /* 설명. Environment를 활용해서 local.server.port를 가져오면 동적으로 할당된 실제 포트번호 확인 가능 */
        return "I'm OK, 포트는 " + env.getProperty("local.server.port");
    }
}

