package com.ohgiraffers.section05.compositekey.subsection01.embedded;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jdk.jfr.Enabled;

import java.util.Objects;

/* 설명.
*  Embeddable 타입은 하나의 값의 묶음이자 불변 객체로 다루는 타입이다.
*  (불변 객체: setter가 없고 필드값에 변화가 생기면 새로운 객체를 생성해야 하는 객체)
*  그리고 equals/hashCode를 오버라이딩 해야 한다.
*  VO와 유사하며 @EmbeddedId로 복합키를 표현하고자 할 때 쓰기도 한다. */


// 복합키에 해당되는 것들을 묶어 하나의 타입으로 묶는 것
// 수정하고 싶으면 하나의 객체를 새로 만들어야 함
@Embeddable
public class MemberPK {

    @Column(name = "member_no")
    private int memberNo;

    @Column(name="member_id")
    private String memberId;

    // setter가 없어야 함(값을 수정할 수 없기에)


    public MemberPK() {
    }


    public MemberPK(int memberNo, String memberId) {
        this.memberNo = memberNo;
        this.memberId = memberId;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MemberPK memberPK = (MemberPK) o;
        return memberNo == memberPK.memberNo && Objects.equals(memberId, memberPK.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberNo, memberId);
    }
}
