package com.ohgiraffers.userservice.service;


import com.ohgiraffers.userservice.dto.UserDTO;
import com.ohgiraffers.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service                // 서비스인터페이스의 하위구현체! 우리가 만든 콩이 이거야~
public class UserServiceImpl implements UserService {


    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registUser(UserDTO userDTO) {
        /* 설명. 회원 가입 할 때 고유 번호 할당 */
        userDTO.setUserId(UUID.randomUUID().toString());

    }
}
