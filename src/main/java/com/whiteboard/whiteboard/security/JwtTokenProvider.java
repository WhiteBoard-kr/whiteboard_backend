package com.whiteboard.whiteboard.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;

//생성자 주입
@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private final UserDetailsService userDetailsService;

    //암호화 키 환경변수로 저장
    @Value("${jwt.secret}")
    private String secretKey;

    //토큰 유효기간
    private final long tokenValidTime = 30 * 60 * 1000L;

    //초기화
    //암호화 키 Base64 인코딩
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    //JWT 생성
    //클레임 포함 (클라이언트 정보)
    public String createToken(String userPk, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(userPk);
        //키 값 쌍으로 저장
        claims.put("roles", roles);
        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                //토큰 발행 시간
                .setIssuedAt(now)
                //토큰 만료 시간
                .setExpiration(new Date(now.getTime() + tokenValidTime))
                //HS256으로 암호화
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }


    //JWT에서 회원 정보 추출
    public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    //JWT에서 인증 정보 조회
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    //http 요청 해더에서 X-AUTH-TOKEN 조회
    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }

    //토큰 유효성 확인
    //유효하다면 토큰 만료 일자 확인
    public boolean validateToken(String jwtToken) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
