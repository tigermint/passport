package com.example.server.service;

import com.example.server.domain.Member;
import com.example.server.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Member join(Member member) {
        Optional OptionalMember = memberRepository.findByEmail(member.getSchoolEmail());
        if (OptionalMember.isPresent()) {
            // 이미 존재하는 email
            return null;
        }
        memberRepository.save(member);
        return member;
    }

    //login
    public Member login(String memberEmail, String memberPW) {
        Optional OptionalMember = memberRepository.findByEmail(memberEmail);
        if (OptionalMember.isPresent()) {
            Member member = (Member)OptionalMember.get();
            if (member.getPassword().equals(memberPW)) {
                return member;
            }else{
                return null; // 비밀번호가 틀린 경우
            }
        }
        return null; // 해당하는 아이디가 없는 경우
    }


    public Optional<Member> findOne(String memberEmail) {
        return memberRepository.findByEmail(memberEmail);
    }
}
