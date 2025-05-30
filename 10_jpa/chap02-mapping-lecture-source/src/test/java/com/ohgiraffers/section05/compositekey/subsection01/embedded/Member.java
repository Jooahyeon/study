package com.ohgiraffers.section05.compositekey.subsection01.embedded;

import jakarta.persistence.*;

@Entity(name="member_section05_subsection01")
@Table(name = "tbl_member_section05_subsection01")
public class Member {

    @EmbeddedId         // embebbed를 활용해서 만든 복합키라는 의미 가짐
    private MemberPK memberPK;              // 복합키를 따로 알려줘야 함.(다른 두개의 속성을 하나의 타입으로 복합키로 묶어둔 것)

    @Column(name="phone")
    private String phone;

    @Column(name="address")
    private String address;

    public Member() {
    }

    public Member(MemberPK memberPK, String phone, String address) {
        this.memberPK = memberPK;
        this.phone = phone;
        this.address = address;
    }

    public MemberPK getMemberPK() {
        return memberPK;
    }

    public void setMemberPK(MemberPK memberPK) {
        this.memberPK = memberPK;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberPK=" + memberPK +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
