package com.ohgiraffers.springcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@EnableDiscoveryClient
public class Chap03SpringCloudGatewayLectureSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap03SpringCloudGatewayLectureSourceApplication.class, args);
    }

}
