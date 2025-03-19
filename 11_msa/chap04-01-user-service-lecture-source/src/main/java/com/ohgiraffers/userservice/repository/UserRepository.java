package com.ohgiraffers.userservice.repository;

import com.ohgiraffers.userservice.aggregate.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository를 상속받음으로 콩으로 됨.
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
