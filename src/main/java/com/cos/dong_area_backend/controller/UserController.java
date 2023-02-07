package com.cos.dong_area_backend.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cos.dong_area_backend.config.encoder.PasswordEncoder;
import com.cos.dong_area_backend.config.jwt.JwtProperties;
import com.cos.dong_area_backend.dto.UserInfoResponseDto;
import com.cos.dong_area_backend.service.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/authed/user")
@RequiredArgsConstructor
@Tag(name = "UserController",description = "사용자 개인을 위한 컨트롤러")
public class UserController {
    private final UserInfoService userInfoService;
    @GetMapping("/userinfo")
    @ResponseBody
    @Operation(summary = "유저정보받기")
    public UserInfoResponseDto userInfo(@RequestHeader Map<String, String> headers){
        String token = headers.get("authorization").replace(JwtProperties.TOKEN_PREFIX,"");
        String username = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(token).getClaim("username").asString();
        return userInfoService.getUserInfo(username);
    }
}
