package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.lang.reflect.Modifier;
import java.util.Map;

// 목적: 핸들러 메소드를 가지고 어떤 것들을 뽑아둘 수 있는가?


@Controller
@RequestMapping("/first")   // 여기로 들어오는 요청은 /first로 받아내고 그 이후에 오는 것들만 아래에서 매핑
/* 설명. 이 Controller 클래스의 핸들러 메소드에서 Model에 "id"라는 키 값으로 담긴 값은 HttpSession에 추가하는 어노테이션 */
/* 설명. HttpSession에서 제공하는 invalidate()가 아닌 SessionStatus가 제공하는 setComplete()를 통해 만료시킬 수 있다. */
@SessionAttributes("id")
public class FirstController {

    /* 설명. 핸들럼 메소드에서 반환형이 없을 경우 요청경로를 반환한다(view의 경로 및 이름) */
    @GetMapping("/regist")
//    public String regist() {                    // 얘가 반환한 애들은 view의 이름이 됨
//        return "/first/regist";
//    }
    public void regist() {          //반환을 아무것도 안하면 요청 자체가 그대로 반환 문자열이구나 인식 (경로 반환,보통 이렇게 축약하여 자주 사용함)
    }

    /* 설명. request는 사용자의 입력값(parameter)를 담는 용도로 쓰고
       Model은 백엔드에서 동적 페이지를 만들 때 사용하는 용도로 쓰자. */
    @PostMapping("regist")
    public String registMenu(HttpServletRequest request, Model model) {
        // 요청을 받은게 insert문을 위한 것 완료된 경우 가공처리하여 반환해야 함
        String name = request.getParameter("name");
//        System.out.println("name = " + name);
        //가공처리
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        // Insert 성공 가정 하에 메세지 담기
        /* 설명. 비즈니스로직 이후 디비에 Insert 성공하고 돌아왔다는 가정 */
        String message = name + "을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 "
                + price + "원으로 등록하였습니다!";
        model.addAttribute("message", message);     // model쓰는 이유:

        return "first/messagePrinter";    // 접두사로는 경로상 templates까지 붙여줌
    }

    @GetMapping("modify")
    public void moidfy() {
    }

    /* 설명.
     *   request의 parameter로 넘어오는 값 들의 key값과 변수명을 작성하고 @RequestParam
     *   어노테이션을 적용하면 알아서 값을 꺼내고 해당 매개변수의 자료형에 맞게 변환까지 해 준다.(물론 가능한 경우)
     *
     *  설명.
     *   1. defaultValue: 사용자의 입력 값이 없거나("") 아니면 request의 parameter 키 값과 일치하지 않는 매개변수 사용 시 매개변수가
     *                   가질 기본 default값을 작성한다.
     *   2. name : request Parameter의 키 값과 다른 매개변수 명을 사용하고 싶을 때 request Parameter의 키 값을 작성한다.
     *
     * */

    @PostMapping("modify1")
    public String modify1(Model model,
                          @RequestParam(name = "name", defaultValue = "디폴트") String modifyName,
                          @RequestParam(name = "modifyPrice", defaultValue = "0") int modifyPrice) {
//                           @RequestParam(name="modifyPrice") int modifyPrice) {
//                            int modifyPrice) { // 넘어온 parameter의 키값과 핸들러 메소드의 매개변수 이름이 같으면 생략 가능

        /* 설명. 넘어온 데이터들로 update를 하고 성공했다는 가정*/

        String message = modifyName + "메뉴의 가격을 " + modifyPrice + "로 변경하였습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    // Map 활용 방식
    @PostMapping("modify2")
    public String modify2(Model model,
                          // 사용자 정보가 맵을 넘어오는 것(스트링, 스트링으로)
                          @RequestParam Map<String, String> parameterMap) {
        String modifyName = parameterMap.get("name");
        int modifyPrice = Integer.parseInt(parameterMap.get("modifyPrice"));

        String message = modifyName + "메뉴의 가격을 " + modifyPrice + "로 변경하였습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    //
    @GetMapping("search")
    public void searchMenu() {
    }


    /* 설명.
     *   핸들러 메소드에 우리가 작성한 클래스(bean X)를 매개변수로 작성하면 스프링이 객체를 만들어주고(기본생성자)
     *   setter로 값도 주입해 준다. 이러한 클래스의 객체를 '커맨드 객체'라고 부른다.
     *   (커맨드 객체는 기본생성자와 setter가 필수이다)
     *
     *   설명.
     *   @ModelAttribute 어노테이션을 활용하면 커맨드 객체를 모델에 attribute로 담아주며 이후 view의 재료로 사용할 수 있다.
     *   (키 값 작성 유무에 따라 화면에서 활용하는 방법이 다르다)
     * */

    // 커맨드 객체에 값을 모두 담는 것
    @PostMapping("search")
    public String searchMenu(@ModelAttribute("menu") MenuDTO menu) {
        System.out.println("menu = " + menu);

        return "first/searchResult";
    }

    @GetMapping("login")
    public void login() {
    }

    //    HttpSession session 세션 공간을 제공해줌(기본 30분 유지되는 공간,만료시간)
    @PostMapping("login")
    public String sessionTest1(String id, String pwd, HttpSession session) {
        System.out.println("id = " + id);
        System.out.println("pwd = " + pwd);

        session.setAttribute("id", id);
        session.setAttribute("pwd", pwd);


        // 쿠키랑 같이 배움(세션 시간 제한)
        /* 설명. 로그인 성공을 가정(회원 조회 이후) HttpSession에 로그인 성공한 회원 정보 저장 */
        return "first/loginResult";
    }


    @GetMapping("logout1")
    public String logoutTest1(HttpSession session) {
        session.invalidate();

        return "first/loginResult";
    }


    /* 설명. Model에 담은 값 중에 일부를 HttpSession에 자동을 담도록 어노테이션 활용 */
    // Model을 활용하려면 클래스에 어노테이션을을 달도 키값 쓰면 됨 @SessionAttributes("id") (model, session에 둘다 담김)
    @PostMapping("login2")
    public String sessionTest2(Model model, String id) {
        model.addAttribute("id", id);

        return "first/loginResult";
    }

    @GetMapping("logout2")
    public String logoutTest2(SessionStatus sessionStatus) {
        sessionStatus.setComplete();                        // 만료 방식(그대로 외워두기)

        return "first/loginResult";
    }

    @GetMapping("body")
    public void body() {
    }

    @PostMapping("body")
    public void body(@RequestBody String body,
                     @RequestHeader("content-type") String contentType,
                     @CookieValue(value="JESSIONID")String sessionID){
        System.out.println("body = " + body);
        System.out.println("contentType = " + contentType);
        System.out.println("sessionId =" + sessionID);
    }
}
