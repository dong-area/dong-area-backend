package com.cos.dong_area_backend.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cos.dong_area_backend.config.auth.PrincipalDetails;
import com.cos.dong_area_backend.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("JwtAuthenticationFilter: attemptAuthentication");

        ObjectMapper om = new ObjectMapper();
        User user = null;

        try {
            user = om.readValue(request.getInputStream(), User.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("JwtAuthenticationFilter: "+user);

        // 유저네임패스워드 토큰 생성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getId(),user.getPassword());
        System.out.println("JwtAuthenticationFilter: 토큰 생성 완료");

        /*
        authenticate() 함수가 호출 되면 인증 프로바이더가 유저 디테일 서비스의
        loadUserByUsername(토큰의 첫번째 파라메터) 를 호출하고
        UserDetails 를 리턴받아서 토큰의 두번째 파라메터(credential)과
        UserDetails(DB값)의 getPassword()함수로 비교해서 동일하면
        Authentication 객체를 만들어서 필터체인으로 리턴해준다.
        */
        Authentication authentication =
                authenticationManager.authenticate(authenticationToken);

        PrincipalDetails principalDetails  = (PrincipalDetails) authentication.getPrincipal();

        System.out.println("Authentication: "+principalDetails.getUser().getUsername());

        System.out.println("==================================");

        return authentication;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {

        PrincipalDetails principalDetails  = (PrincipalDetails) authResult.getPrincipal();

        //Hash방식
        String jwtToken = JWT.create()
                .withSubject("Jwt Response")
                .withClaim("id",principalDetails.getUser().getId())
                .withClaim("username",principalDetails.getUser().getUsername())
                .sign(Algorithm.HMAC512(JwtProperties.SECRET));

        System.out.println("successfulAuthentication!!");

        response.addHeader(JwtProperties.HEADER_STRING,JwtProperties.TOKEN_PREFIX+jwtToken);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        System.out.println("unsuccessfulAuthentication!!");
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
