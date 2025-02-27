package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

/* 설명.
*  section03에서는 ComponentScan과 관련하여 Java클래스에서 @ComponentScan범위를
*  bean으로 등록하는 방법을 다룬다(실제 bean으로 등록할 때 자주 쓰는 어노테이션)*/

@Configuration("testConfig")
// +) 자동으로 훑어봐!



/* 설명. 1. 기본적으로는 설정 파일이 있는 패키지 및 하위만 Scan하지만 basePackagers를 바꾸면 다른 범위까지 가능하다 _ 일반적으로 이렇게 사용*/
//@ComponentScan(basePackages = "com.ohgiraffers")
// +) basePackages = "com.ohgiraffers" 속성 설정(범위설정?)

/* 설명. 2. 범위 및 필터를 적용해서 제외하고자 하는 bean을 등록하는 경우(excludeFilters)*/
// +) 어노테이션으로 필터링 가능(범위 설정할 수 있음.)
// +)  블랙리스트방식(excludeFilters 기존 범위에서 안보고 싶은 것들) / 화이트체크리스트(includeFilters)
//@ComponentScan(basePackages = "com.ohgiraffers",
//        excludeFilters = {
//                @ComponentScan.Filter(
//                        /* 설명. 2-1. 타입으로 설정*/
////                type = FilterType.ASSIGNABLE_TYPE,
////                classes = {MemberDAO.class}
//
//                        /* 설명. 2-2. 어노테이션 종류로 설정 */
//                        type = FilterType.ANNOTATION,
//                        classes = {org.springframework.stereotype.Repository.class}
//                )
//        })


/* 설명. 3. 범위 및 필터를 적용해서 등록하고자 하는 bean을 등록하는 경우(includeFilters) */
@ComponentScan(basePackages = {"com.ohgiraffers", "com"},
        useDefaultFilters = false,                          // 현재 설정 파일 bean 제외 나머지는 off (살리고 싶은 것만 살릴 수 있음)
        includeFilters = {
            @ComponentScan.Filter(
                    type = FilterType.ASSIGNABLE_TYPE,
                    classes = {MemberDAO.class}             // MemberDAO 타입 bean만 등록
            )
        })
public class ContextConfiguration {

}
