package com.whiteboard.whiteboard.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

//생성자 주입
@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    //암호화 키 환경변수로 저장
    @Value("${jwt.secret}")
    private String secretKey;
}
