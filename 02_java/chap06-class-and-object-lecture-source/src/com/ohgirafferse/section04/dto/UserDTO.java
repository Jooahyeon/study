package com.ohgirafferse.section04.dto;
//형태가 정해진 템플릿 형태의 클래스

import java.util.Date;

/*설명.
 *  자바빈(Java Bean)이란?
 *   JSP에서 사용되는 표준 액션 태그로 접근할 수 있게 만든 자바 클래스 형태이다.
 *   자바 코드를 모르는 웹 퍼블리셔들도 자바 코드를 사용할 수 있도록 태그 형식으로 지원하는 문법을
 *   의미하는데, 그 때 사용할 수 있도록 규칙을 지정해 놓은 java 클래스를 자바빈(Java Bean)이라고 부른다.
 *   지금은 특정 목적 및 프레임워크를 위해 작성하는 규칙이라고 보면 된다. (자동호출하기 때문에 만들어야 함)
 *    (자바로 웹을 만들 때 jsp태그들로 작성함 = 자바빈 형태. 각 메소드가 통일된 클래스로 만들어둬야 함.)
 * */

/*설명.
*  자바빈 작성규칙
*   1. 자바빈은 특정 패키지에 속해 이써야 함(default 패키지 사용 금지_패키지 안에 클래스가 있게 하자)
*   2. 필드의 접근 제어자는 private로 선언해야 함(캡슐화 적용)
*   3. 기본 생성자가 명시적으로 존재해야 함(매개변수 있는 생성자는 선택사항)
*   4. 모든 필드에 접근 가능한 설정자(setter)와 접근자(getter)가 public으로 작성되어 있어야 함.
*   5. 직렬화(Serializable 구현)을 고려해야 한다.(선택사항)  -> 몰라도 됨.
* */
public class UserDTO /*implements Serializable*/ {
    //형태가 정해진 템플릿 형태의 클래스

    private String id;
    private String pwd;
    private String name;
    private java.util.Date enrollDate;

    public UserDTO() {
    }

    public UserDTO(String id, String pwd, String name, Date enrollDate) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.enrollDate = enrollDate;
    }

    //private라 캡슐화되어 접근이 안되는 상태 이때 접근 하고 싶은 경우 기본생성자 + get,set 활용 (명명규칙 'set,get+변수명' 낙타표기법)
    // -> 개발자가 아닌 특정 프레임워크 or 웹퍼블리셔가 사용

    // get,set 만들 때, generater로 자동완성 권장
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    //toString 작성
    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", enrollDate=" + enrollDate +
                '}';
    }
}
