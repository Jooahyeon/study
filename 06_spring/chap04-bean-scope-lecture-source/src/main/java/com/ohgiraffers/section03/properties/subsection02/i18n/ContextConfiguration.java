package com.ohgiraffers.section03.properties.subsection02.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ContextConfiguration {
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        /* 설명. 접속하는 세션의 로케일(Locale)에 따라 자동 재로딩하는 용도의 MessageSource 구현체 */
        ReloadableResourceBundleMessageSource messageSource =
              new ReloadableResourceBundleMessageSource();

        /* 설명. 다국어 메시지를 읽어올 설정파일(properties)의 이름과 경로를 설정한다 */
        messageSource.setBasename("section03/properties/subsection02/i18n/message");

        /* 설명. 불러온 메시지를 설정한 해당 시간동안 캐싱한다.*/
        messageSource.setBasename(String.valueOf(10));

        /* 설명. 기본 인코딩 셋을 설정할 수 있다. */
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;

    }
}
