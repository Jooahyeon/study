package com.ohgiraffers.section03.filterstream.dto2;

import java.io.Serializable;

public class MemberDTO implements Serializable {


    //implements Serializable 객체입출력할 클래스에는 있어야함(객체 내용을 직렬화 해)
    //객체입출력읟 대상 클래스에는 달아야 함 implements Serializable
    //

    /*설명. transient 키워드가 달린 필드는 객체 입출력시 (직렬화 시 대상이 되지 않는다.) 출력되지 않음
     *  옛날에 pwd를 null값을 넣고 싶을 때 사용*/
    private String id;

    /* 설명. transient 키워드가 달린 필드는 객체 입출력 시 (직렬화 시 대상이 되지 않는다.) 출력 되지 않는다. */
    private transient String pwd;
    private String name;
    private String email;
    private int age;
    private char gender;

    public MemberDTO() {
    }

    public MemberDTO(String id, String pwd, String name, String email, int age, char gender) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
