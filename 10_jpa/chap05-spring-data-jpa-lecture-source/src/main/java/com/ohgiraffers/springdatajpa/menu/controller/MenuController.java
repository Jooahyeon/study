package com.ohgiraffers.springdatajpa.menu.controller;


import com.ohgiraffers.springdatajpa.common.Pagination;
import com.ohgiraffers.springdatajpa.common.PagingButtonInfo;
import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.awt.SystemColor.menu;

@Controller
@RequestMapping("/menu")
@Slf4j   // Lombok을 깔아야지만 가능함 (상위에 변수를 지정하지 않아도 로그라는 이름으로 사용 가능_내부적으로 logger사용)
public class MenuController {
    //생성자주입
    private final MenuService menuService;


    /* 설명.
     * Logger를 활용한 로그 생성 이유?
     *  1. println보다 성능적으로 우수
     *  2. 외부 리소스 파일로 따로 저장 및 송출이 가능하다 (사용자의 로그를 엑셀 파일로 저장 가능)
     *  3. 로그레벨에 따른 확인이 가능하다 (개발: debug, 서비스: info)_yml 설정을 통해
     * */


    // 타입만 인지시켜도 됨
    // Logger logger = LoggerFactory.getLogger(MenuController.class)            // (타입지정) 방식 1
    Logger logger = LoggerFactory.getLogger(getClass());                        // 방식2

    @Autowired //(명시적으로 써줄 것)
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // 요청이 오면 요청상 경로를 뽑아서(변수로 받아서) 핸들러 메소드로 쓸 수 있다
    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable int menuCode, Model model) {
//        System.out.println("menuCode = " + menuCode);
        // 로그로 찍어보는건 이렇게 하시오~
//        logger.debug("menuCode= {}", menuCode);           // 방식1
//        logger.info("menuCode= {}", menuCode);            // 방식2
        log.debug("menuCode={}", menuCode);                 // 방식3 - 요 방식을 사용해라(lombok을 활용)

        MenuDTO menu = menuService.findMenuByCode(menuCode);

        model.addAttribute("menu", menu);

        return "menu/detail";
    }

    /* 설명. 페이징 처리 전 */
    @GetMapping("/list")
    public String findMenuList(Model model) {
        List<MenuDTO> menuList = menuService.findMenuList();

        model.addAttribute("menuList", menuList);

        return "menu/list";
    }
    /* 설명. 페이징 처리 후
    *  설명.
    *  @PageableDefault
    *   1. 기본 한 페이지에 10개의 데이터(size, value)
    *   2. 기본 1페이지부터 (0부터)
    *   3. 기본 오름차순(ASC)
    * */

    @GetMapping("/list")
    public String findMenuList(@PageableDefault Pageable pageable, Model model) {
        log.debug("pageble: {}", pageable);

        Page<MenuDTO> menuList = menuService.findMenuList(pageable);

        log.debug("조회한 내용 목록 : {}", menuList.getContent());
        log.debug("총 페이지 수 : {}", menuList.getTotalPages());
        log.debug("총 메뉴 수 : {}", menuList.getTotalElements());
        log.debug("해당 페이지에 표시 될 요소 수 : {}", menuList.getSize());
        log.debug("해당 페이지에 실제 요소 수 : {}", menuList.getNumberOfElements());
        log.debug("Page의 number가 처음이면(첫 페이지면): {}", menuList.isFirst());
        log.debug("Page의 number가 마지막이면(마지막 페이지면): {}", menuList.isLast());

        /* 설명. Page객체를 통해 PagingButtonInfo 추출 */
        PagingButtonInfo paging = Pagination.getPagingButtonInfo(menuList);

        model.addAttribute("menuList", menuList);
        model.addAttribute("paging", paging);

        return "menu/list";
    }

}
