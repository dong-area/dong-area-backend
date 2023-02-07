package com.cos.dong_area_backend.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cos.dong_area_backend.config.encoder.PasswordEncoder;
import com.cos.dong_area_backend.config.jwt.JwtProperties;
import com.cos.dong_area_backend.dto.LoginRequestDto;
import com.cos.dong_area_backend.entity.User;
import com.cos.dong_area_backend.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.util.Map;

@Controller
@RequestMapping("/auth")
@CrossOrigin("*")
@Tag(name = "AuthController", description = "인증관련 컨드롤러")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/join")
    @ResponseBody
    @Operation(summary = "회원가입")
    public String join(@RequestBody LoginRequestDto loginRequestDto) {
        loginRequestDto.setPassword(passwordEncoder.encode(loginRequestDto.getPassword()));
        User user = User.builder()
                .id(loginRequestDto.getId())
                .password(loginRequestDto.getPassword())
                .username(loginRequestDto.getUsername())
                .roles("ROLE_USER")
                .clubname(loginRequestDto.getClubname())
                .stu_id(loginRequestDto.getStu_id())
                .build();
        System.out.println("join: "+user);
        userRepository.save(user);
        return "join succeed!!!";
    }
    @PostMapping("/authed/username")
    @ResponseBody
    @Operation(summary = "유저이름 받기")
    public String username(@RequestHeader Map<String, String> headers){
        String token = headers.get("authorization").replace(JwtProperties.TOKEN_PREFIX,"");
        String username = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(token).getClaim("username").asString();
        return username;
    }
}
