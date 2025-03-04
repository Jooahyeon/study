package com.ohgiraffers.section02.xmlconfig;


import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        // +) 스프링 컨테이너에서 하나의 객체만 갖고 있는 것이 기본(default)_싱글톤으로 관리됨-> 나중에 설정을 바꿔줄 수 있음
        // +) GenericXmlApplicationContext (xml활용)
        ApplicationContext context =
                new GenericXmlApplicationContext("section02/xmlconfig/spring-context.xml");

        /* 설명. 컨테이너에 들어있는 모든 bean의 이름(id)을 확인 */
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }
        /* 설명. 1. bean의 id를 가지고 컨테이너에서 추출 */

        // +) 멤버라는 이름의 콩을 줘!(기본 object타입이라 다운캐스팅)
        // 멤버라는 객체에 들어있는지 확인하는 작업
//        MemberDTO member = (MemberDTO)context.getBean("member");

        /* 설명. 2. bean의 클래스의 메타 정보(bean의 타입)를 전달하여 추출_.class를 통해 타입만 추출
         (타입으로도 콩을 구분할 수 있구나! 정도 알기) */
//        MemberDTO member = context.getBean(MemberDTO.class);

        /* 설명. 3. bean의 Id와 클래스의 메타 정보를 전달하여 추출 */
        MemberDTO member = context.getBean("member", MemberDTO.class);
        System.out.println("member = " + member);

    }
}
