package com.ohgiraffers.section04.testapp.service;

/* 설명. 트랜잭션 처리(성공 실패에 따라 commit/rollback) 및 회원관리 비즈니스 로직 처리
    (유효성검사, 회원추가삭제의 흐름처리, 값의 가공처리 등 DB들어가기 전 처리)
     얘 다음은 repository로 처리함*/

import com.ohgiraffers.section04.testapp.aggregate.AccountStatus;
import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.repository.MemberRepository;

import java.util.ArrayList;

public class MemberService {

    private final MemberRepository mr = new MemberRepository();          //Repository에 있는 걸 갖다 쓸 수 있음(관련)

    public void findAllMembers() {                                       //서비스계층부터는 이름을 좀 달리함(대게)
        ArrayList<Member> findMembers = mr.selectAllMembers();    
                                                                         //순수 자바이기에 조회의 결과를 자바에서 담고 있어야함
                                                                         //=>Arraylist활용
        System.out.println("Service에서 조회 확인:");
        for (Member member : findMembers) {
            System.out.println(member);
        }
    }

    public void findMemberBy(int memNo) {
        Member findMember = mr.selectMemberBy(memNo);

        if(findMember != null) {
            System.out.println("회원 조회 성공: " + findMember);
        } else {
            System.out.println(memNo + "번 회원은 없습니다.");
        }
    }

    public void registMember(Member member) {
//        System.out.println("회원가입에서 입력 받은 값 들어있는지 확인: " + member);       // 테스트로 찍어봄 다시 ㅈ지울겨
        /* 설명. 회원가입 시 입력받은 값 제외 두개를 마저 채워준다. */
        /* 설명. 1. 회원 번호 추가 _ 마지막 회원 조회(레포에서 조회,select) + 회원 번호 추가(insert) */
        int lestMemberNo = mr.selecLastMemberNo();
        member.setMemNo(lestMemberNo + 1);

        /* 설명. 2. 회원 활성화 상태 추가 */
        member.setAccountStatus(AccountStatus.ACTIVE);



        /*설명. 모든 DML작업(Insert/Update/Delete)이 일어난 행(객체)의 갯수 */
        int result = mr.insertMember(member);
//        System.out.println("insert 성공 실패 여부: " + result);

        if (result == 1) {
            System.out.println("회원가입을 축하드립니다!! " + member.getId() + "님");
        } else {
            System.out.println("회원가입에 실패하였습니다.");
        }
    }

    public Member findMemberForMod(int memNo) {
        Member selectedMember = mr.selectMemberBy(memNo);    // 원본

        if (selectedMember != null) {           // 해당 회원이 조회되었을 때

            /*설명. 조회된 회원을 그대로 반환해서 수정하면 Repository의 컬렉션에 담긴 객체가 수정된다 */
            /*설명. 따라서 우리는 사본의 개념을 만들어 Repository의 컬렉션이 오염되지 않도록 할 것임 */

            Member newInstance = new Member();    //사본
            newInstance.setMemNo(selectedMember.getMemNo());
            newInstance.setId(selectedMember.getId());
            newInstance.setPwd(selectedMember.getPwd());
            newInstance.setAge(selectedMember.getAge());

            /* 설명. 취미는 배열이고 배열은 깊은 복사를 해 주어야 사본이 회원이 따로 취미 배열을 가지게 된다.*/
            String[] copiedHobbies = selectedMember.getHobbies().clone();  //깊은복사
            newInstance.setHobbies(copiedHobbies);            //깊은복사
            newInstance.setBloodType(selectedMember.getBloodType());
            newInstance.setAccountStatus(selectedMember.getAccountStatus());

            System.out.println("조회된 회원(의 사본)조회 : " + newInstance);
            return newInstance;

        } else {
            System.out.println("그런 회원은 없습니다.");
        }
        return selectedMember;
    }

    public void modifyMember(Member reformedMember) {         //수정페이지를 거친 후
        int result = mr.updateMember(reformedMember);

        if (result == 1) {
            System.out.println(reformedMember.getId() + "회원님의 정보를 수정했습니다!");
        } else {
            System.out.println("회원정보 수정 실패");
        }
    }

    public void removeMember(int removeMemNo) {
        int result = mr.deleteMember(removeMemNo);
        if (result == 1) {
            System.out.println(removeMemNo + "번 회원 탈퇴를 성공하였습니다");
        } else {
            System.out.println("회원 탈퇴를 실패하였습니다.");      //throw new RemoverMemberException();으로 t-c해서 출력 가능
        }
    }
}
