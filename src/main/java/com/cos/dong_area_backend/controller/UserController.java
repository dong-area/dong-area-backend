package com.cos.dong_area_backend.controller;

import com.cos.dong_area_backend.config.jwt.JwtProperties;
import com.cos.dong_area_backend.dto.UserInfoResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authed/user")
public class UserController {
    @GetMapping("/userinfo")
    public UserInfoResponseDto userInfo(@RequestHeader HttpHeaders header){
        return null;
    }
}
