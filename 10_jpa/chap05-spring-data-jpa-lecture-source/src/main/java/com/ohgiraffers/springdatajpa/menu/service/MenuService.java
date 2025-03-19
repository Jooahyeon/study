package com.ohgiraffers.springdatajpa.menu.service;

import com.ohgiraffers.springdatajpa.menu.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Category;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.repository.CategoryRepository;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service    //bean형태로 만들어야 menuController에서 에러가 안생김
@Slf4j
public class MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository,
                       ModelMapper modelMapper,
                       CategoryRepository categoryRepository) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    /* 설명. 1. findById() */
    // 조회를 하고싶은 엔티티의 레포지토리를 따로 만들어야 함
    public MenuDTO findMenuByCode(int menuCode) {

        // 단순조회 (where절을 활용한 단일행 단순열 조회시 사용!)
        // .get()을 안써주면 optional로 인해 에러 발생
//        Menu menu = menuRepository.findById(menuCode).get();
        Menu menu = menuRepository.findById(menuCode).orElseThrow(IllegalAccessError::new);
        log.debug("menu: {}", menu);                    // 실제 개발시 서비스 계층에서 해당 값 추출한다는 내용 작성해야해

        return modelMapper.map(menu, MenuDTO.class);
    }

    /* 설명. 2. findAll() (페이징 처리 전) */
    public List<MenuDTO> findMenuList() {
        // findAll(정렬타입(필드명)
        List<Menu> menus = menuRepository.findAll(Sort.by("menuCode").descending());

        List<MenuDTO> resultList = menus.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .collect(Collectors.toList());
        return resultList;
    }

    /* 설명. 3. findAll() (페이징 처리 후)*/
    public Page<MenuDTO> findMenuList(@PageableDefault Pageable pageable) {
        // 1페이지에 대한 정의
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),                                 // 한 페이지 사이즈 정의
                Sort.by("menuCode").descending());           // 페이지 정렬 기준
        Page<Menu> menuList = menuRepository.findAll(pageable);

        return menuList.map(menu -> modelMapper.map(menu, MenuDTO.class));
    }


    /* 설명. 4. QueryMethod 활용 */
    public List<MenuDTO> findMenuPrice(int menuPrice) {

        List<Menu> menus = menuRepository.findByMenuPriceGreaterThan(menuPrice);

        return menus.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .collect(Collectors.toList());
    }

    /* 설명. 5. jpql 및 native sql 활용 */
    // findAllCategories(나의 메소드) 인터페이스에 새로운 이름을 만들어 직접 추가
    public List<CategoryDTO> findAllCategory() {

        List<Category> categories = categoryRepository.findAllCategories();

        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    /* 설명. 6. 추가하기*/
    @Transactional
    public void registMenu(MenuDTO newMenu) {
        // save(엔티티)
        menuRepository.save(modelMapper.map(newMenu, Menu.class));
    }

    @Transactional
    public void modifyMenu(MenuDTO modifyMenu) {

        /* 설명. 수정할 메뉴를 가져와서(영속 상태로 만들어) 영속 상태인 객체를 수정하면 update */
        Menu foundMenu = menuRepository.findById(modifyMenu.getMenuCode()).get();
        foundMenu.setMenuName(modifyMenu.getMenuName());
    }

    @Transactional
    public void deleteMenu(int menuCode) {
        menuRepository.deleteById(menuCode);
    }
}
