package com.ohgirafferse.section08.uses;

public class MemberFinder {
    public Member[] findAllMemebers() {
        return MemberRepository.findAllMembers();
    }

    public Member[] findAllMembers() {
        return null;
    }
}
