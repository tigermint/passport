package com.example.server.controller;

import com.example.server.domain.Member;
import com.example.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/login")
    public Member login(@RequestBody Member member) {
        return memberService.login(member.getSchoolEmail(), member.getPassword());
    }

    @PostMapping("/signUp")
    public Member signUp(@RequestBody Member member) {
        return memberService.join(member);
    }

}
