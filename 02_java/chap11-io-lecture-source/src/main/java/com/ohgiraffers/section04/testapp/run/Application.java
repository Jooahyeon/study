package com.ohgiraffers.section04.testapp.run;
// 프론트엔드 역할 R/V(view)의 역할

import com.ohgiraffers.section04.testapp.aggregate.BloodType;
import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.service.MemberService;
import java.util.Scanner;

public class Application {

    private static final MemberService ms = new MemberService();           //백엔드 시작
    // final => 객체가 한번 들어오면 하나만 고정
    // 즉, 해당 메뉴에 대해서 처리하는 객체는 하나로 고정하고 시작
    // (결론 서비스객체(요청받는)는 하나면 된다, 사용자마다 하나의 객체만 사용한다)

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("====== 회원관리프로그램 =====");
            System.out.println("1. 모든 회원 정보 보기");
            System.out.println("2. 회원 찾기");
            System.out.println("3. 회원 가입");
            System.out.println("4. 회원 정보 수정");
            System.out.println("5. 회원 탈퇴");                 //soft delete(다 삭제되지않고 기록은 남는?)
            System.out.println("9. 프로그램 종료");
            System.out.println("메뉴를 선택해주세요: ");
            int input = sc.nextInt();

            switch (input) {
                case 1: ms.findAllMembers(); break;
                case 2: ms.findMemberBy(chooseMemNo());break;
                case 3: ms.registMember(singUp()); break;
                case 4:
                    Member selected = ms.findMemberForMod(chooseMemNo());        //수정할거 먼저 검색
                    if (selected == null) continue;
                    ms.modifyMember(reform(selected));              //화면쪽에서 수정 요청(서비스에 호출하는 과정)
                        break;
                case 5: ms.removeMember(chooseMemNo()); break;
                case 9:                                  //프로그램 종료(main메소드 종료)
                    System.out.println("회원관리 프로그램을 종료합니다. "); return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다");
            }
        }
    }

    /* 설명. 회원 정보 수정 페이지로 넘어가*/
    private static Member reform(Member modifyMember) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(" ==== 회원 정보 수정 서브 메뉴 ==== ");
            System.out.println("1. 패스워드");
            System.out.println("2. 나이");
            System.out.println("3. 취미");
            System.out.println("4. 혈액형");
            System.out.println("9. 메인 메뉴로 돌아가기");
            System.out.println("내용을 선택하세요: ");
            int chooseNo = sc.nextInt();
            sc.nextLine();          // 버퍼의 개행 제거용
            switch (chooseNo) {
                case 1:
                    System.out.print("수정 할 패스워드를 입력하세요.");
                    modifyMember.setPwd(sc.nextLine());
                    break;
                case 2:
                    System.out.print("수정 할 나이를 입력하세요: ");
                    modifyMember.setPwd((sc.nextLine()));
                    break;
                case 3:
                    System.out.print("수정 할 취미를 입력하세요: ");
                    modifyMember.setHobbies(resetHobbies());            //배열은 단순 Scanner로 입력 X / resetHobbies()라는 보조메뉴 생성
                    break;
                case 4:
                    System.out.print("수정 할 혈액형을 입력하세요: ");
                    modifyMember.setBloodType(resetBloodType());        // enum은 단순 Scanner로 입력 X
                    break;
                case 9:
                    System.out.print("메인 메뉴로 돌아갑니다.");
                    return modifyMember;                                //내가 수정한 내용만 수정되고 수정되지 않은것은 그대로 반환
                default:
                    System.out.print("번호를 다시 제대로 입력해주세요.");
            }

        }
    }

    private static BloodType resetBloodType() {
        Scanner sc = new Scanner(System.in);
        System.out.println("수정 할 혈액형을 입력하세요. (A, AB, B, O)");
        String bloodType = sc.nextLine();
        BloodType bt = null;
        switch (bloodType) {
            case "A": bt = BloodType.A; break;
            case "AB": bt = BloodType.AB; break;
            case "B": bt = BloodType.B; break;
            case "O": bt = BloodType.O; break;
        }
        return bt;
    }
    //클론으로 사본을 만드는 이유(수정을 안할 경우를 고려)
    private static String[] resetHobbies() {
        Scanner sc = new Scanner(System.in);
        System.out.println("수정 할 취미의 갯수를 입력하세요(1개 이상)");
        int length = sc.nextInt();
        sc.nextLine();

        String[] hobbies = new String[length];
        for (int i = 0; i < hobbies.length; i++) {
            System.out.println((i + 1) + "번째 취미를 입력하세요: ");
            String input = sc.nextLine();
            hobbies[i] = input;
        }

        return null;
    }

    /*설명. 회원 가입 페이지 */
    //변수에 담아 만들 때 생성자 5개 만들거나 아래처럼 만들기
    private static Member singUp() {
        Member member = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("아이디를 입력하세요: ");         //아이디 중복체크 추가해도 됨
        String id = sc.nextLine();

        System.out.println("패스워드를 입력하세요: ");
        String pwd = sc.nextLine();

        System.out.println("나이를 입력하세요: ");
        int age = sc.nextInt();

        System.out.println("입력할 취미의 갯수를 입력하세요 (숫자는 1 이상) : ");
        int length = sc.nextInt();
        sc.nextLine();          //버퍼에 남은 엔터 제거용

        String[] hobbies = new String[length];
        for (int i = 0; i < hobbies.length; i++) {
            System.out.println((i + 1) + "번째 취미를 입력하세요: ");
            String input = sc.nextLine();
            hobbies[i] = input;
        }

        System.out.println("혈액형을 입력하세요(A, AB, B, O):   ");
        String bloodType = sc.nextLine();
        BloodType bt = null;
        switch (bloodType) {
            case "A": bt = BloodType.A; break;
            case "AB": bt = BloodType.AB; break;
            case "B": bt = BloodType.B; break;
            case "O": bt = BloodType.O; break;
        }

        member = new Member(id, pwd, age, hobbies, bt);         //객체가 되어 3번으로 던져짐

        return member;      //입력 받은 값을 하나로 뭉침
    }

    /* 설명. 회원 번호를 입력 받아 int로 반환하는 메소드 */
    private static int chooseMemNo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("회원 번호를 입력하세요: ");
        return sc.nextInt();
    }
}
