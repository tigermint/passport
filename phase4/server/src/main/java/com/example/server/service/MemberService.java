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
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member;
    }

    private void validateDuplicateMember(Member member){
        memberRepository.findByEmail(member.getSchoolEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원정보 입니다");
                });
    }

    public Optional<Member> findOne(String memberEmail) {
        return memberRepository.findByEmail(memberEmail);
    }
}
