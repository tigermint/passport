package com.example.server.config;

import com.example.server.repository.JdbcMemberRepository;
import com.example.server.repository.MemberRepository;
import com.example.server.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class MemberConfig {

    // Spring 자체적으로 dataSource 제공
    private final DataSource dataSource;

    @Autowired
    public MemberConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcMemberRepository(dataSource);
    }
}
