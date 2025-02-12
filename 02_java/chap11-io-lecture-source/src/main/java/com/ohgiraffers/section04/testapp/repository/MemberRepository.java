package com.ohgiraffers.section04.testapp.repository;

import com.ohgiraffers.section04.testapp.aggregate.AccountStatus;
import com.ohgiraffers.section04.testapp.aggregate.BloodType;
import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;
     /* 설명. 데이터베이스 개념(Member 관련 파일)과 입출력(CRUD)을 위해 만들어지며
         성공데이터 또는 성공/실패 여부를 반환(java의 컬렉션 개념으로 데이터를 관리하기도 한다) */
public class MemberRepository {                 //객체가 생성되지마자  = 프로그램 키자마자

    /*설명.(초기작업) 초기에 Member파일이 없다면 파일을 만들어 더미데이터(dummy data)를 쌓는다. */
    private final ArrayList<Member> memberList = new ArrayList<>();  //속이 빈 객체, 조회가 안되면 속이 비었냐 아니냐로 확인(is empty활용)
    private final File file =
            new File("src/main/java/com/ohgiraffers/section04/testapp/db/memberDB.dat");  //DB와의 연결정보

    /*설명. 프로그램구동시 MemberRepository 생성자가 호출되며 초기에 실행할 내용들  */
    public MemberRepository() {
        if (!file.exists()) {                   //파일 없으면 트루
            ArrayList<Member> defaultMembers = new ArrayList<>();
            defaultMembers.add(new Member(1, "user01", "pass01", 20,
                    new String[]{"발레", "수영"}, BloodType.A, AccountStatus.ACTIVE));
            defaultMembers.add(new Member(2, "user02", "pass02", 10,
                    new String[]{"게임", "영화시청"}, BloodType.B, AccountStatus.ACTIVE));
            defaultMembers.add(new Member(3, "user03", "pass03", 30,
                    new String[]{"음악감상", "독서", "명상"}, BloodType.AB, AccountStatus.ACTIVE));

            saveMember(defaultMembers);

        }
        loadMember();
    }
//    /*설명. 파일로부터 회원 객체들을 읽어와서 memberList 컬렉션에 저장 */
    private void loadMember() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        )) {
            while (true) {
               memberList.add((Member) ois.readObject());
            }
        } catch (EOFException e) {
            System.out.println("회원 정보 다 읽어옴");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*설명 ArrayList<Members>를 받으면 파일로 출력하는 메소드(feat. 덮어씌우는 기능)*/
    private void saveMember(ArrayList<Member> defaultMembers) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)
                    )
            );

            for (Member member : defaultMembers) {
                oos.writeObject(member);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Member> selectAllMembers() {
        return memberList;
    }

    public Member selectMemberBy(int memNo) {
        Member returnMember = null;

        for (Member member : memberList) {
            if (member.getMemNo() == memNo) {
                returnMember = member;
            }
        }
        return returnMember;
    }

        //데이터와 관련된건 여기에 작성
         public int selecLastMemberNo() {
             Member lastMember = memberList.get(memberList.size() - 1);
             return lastMember.getMemNo();
         }

         //첫 헤더 제외하고 더이상 헤더가 붙지 않고 스트림이 날아가도록 만듬
         public int insertMember(Member member) {
             /* 설명. 헤더가 추가되지 않는 ObjectOutputStream 클래스 정의(MyObjectOutputStream) */
             MyObjectOutput moo = null;
             int result = 0;

             try {
                 moo = new MyObjectOutput(
                         new BufferedOutputStream(
                                 new FileOutputStream(file, true)  //이어붙여서 쓰려고 true
                         )
                 );

                 /*설명. 파일로 신규 회원 추가하기 */
                 moo.writeObject(member);

                 /*설명. 컬렉션에도 신규 회원 추가하기
                    (MyOutputStream으로 이어붙인 정보는 다시 입력 받아도 이전 파일로 인식함)
                    프로그램을 껐다 키면 다시 재인식이 되긴 함
                    */
                 memberList.add(member);

                 result = 1;    //성공, 한개를 insert한 개념으로 1

             } catch (IOException e) {
                 throw new RuntimeException(e);
             } finally {
                 try {
                     if (moo != null) moo.close();
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }
             }
            return result;
         }
        /*설명. 수정된 사본이 넘어오면 컬렉션에 담긴 동일한 회원을 update하고 컬렉션의 회원 정보로 파일을 덮어씌운다. */
         public int updateMember(Member reformedMember) {
             for (int i = 0; i < memberList.size(); i++) {
                 if (memberList.get(i).getMemNo() == reformedMember.getMemNo()) {
                     memberList.set(i, reformedMember);         //컬렉션 update!, set으로 원하는 위치에 있는 거를 갈아끼움(수정함)
                    saveMember(memberList);                     //파일 update!(덮어씌우기) (강사님 메소드명과 다름 주의!)

                     return 1;                                  //업데이트 됐을 때

                 }
             }

             return 0;                                          // 업데이트 안됐을 때 (존재하는 객체가 넘어오기에 실행될 일 없음)
         }

         /* 설명. soft delete(일종의 업데이트)를 통해 회원 탈퇴를 구성*/
         // 바꿔줄꺼면 둘 다 바꿔줘야 함.. (컬렉션과 파일)
         public int deleteMember(int removeMemNo) {
             int result = 0;

             for (Member mem : memberList) {
                 if (mem.getMemNo() == removeMemNo) {
                     mem.setAccountStatus(AccountStatus.DEACTIVATED);
                     result = 1;
                     saveMember(memberList);                    //한명 탈퇴시켜도 덮어씌워야 해(jpa와 방법이 비슷(영속성데이터))
                 }
             }

             return result;
         }
     }
