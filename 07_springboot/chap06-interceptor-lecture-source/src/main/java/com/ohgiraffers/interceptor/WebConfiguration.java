package com.ohgiraffers.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 의존성 주입받을 대상이 bean(StopwatchInterceptor)이 되게 한다. 의존성 주입받는 애들을 add.interceptor로 계속 주입 받음

/* 설명. Interceptor 추가 및 static(정적) 리소스 호출 경로 등록 설정 -> 인터셉터가 특정 상황에서 동작 안하도록 할 수 있음 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    //WebMvcConfigurer 여기서 인터셉터를 등록할거여서 WebConfiguration 만들어둠

    private StopwatchInterceptor stopwatchInterceptor;

    @Autowired
    public WebConfiguration(StopwatchInterceptor stopwatchInterceptor) {
        this.stopwatchInterceptor = stopwatchInterceptor;
    }

    // localhost:8080/css/test.css 으로 경로 설정 가능(.excludePathPatterns("/css/**");) 설정
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(stopwatchInterceptor)
                .excludePathPatterns("/css/**");

    }

    // 웹서버의 설정 -> 톰캣 동작 안함, 정적 리소스 등록을 위해 활용함
    // 파일서버가 되기도 함(ftp) 즉, 파일만 주는 서버가 되는 것
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:static/css/")
                .setCachePeriod(100);
    }
}
