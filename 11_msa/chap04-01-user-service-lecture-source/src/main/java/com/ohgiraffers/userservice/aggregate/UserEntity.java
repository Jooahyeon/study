package com.ohgiraffers.userservice.aggregate;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data               // bean 형태로 바꿔줌
@Table(name = "tbl_member")
// user -> userentity로 써라 아니면 Member (user가 시큐리티에 지정이 되어 있어서 겹침)
public class UserEntity {
    // 입력 받는 그릇과 응답할 그릇은 다를 수 있다
    // Vo로 나눠도 괜찮고 DTO로 한번에 퉁쳐도 된다

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;                            // 회원 번호 (auto-increment)

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;                       // 회원 이메일 (ID 개념)

    @Column(name = "pwd", nullable = false)
    private String pwd;                         // 회원의 비밀번호

    @Column(name = "name", nullable = false, length = 50)
    private String name;                        // 회원의 실제 이름

    @Column(name = "userId", nullable = false, unique = true)
    private String userId;                      // 회원 가입 이후 자동으로 발생 할 고유 번호(일종의 닉네임)
}
