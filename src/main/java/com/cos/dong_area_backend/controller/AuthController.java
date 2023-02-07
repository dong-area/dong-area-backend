package com.cos.dong_area_backend.controller;

import com.cos.dong_area_backend.config.encoder.PasswordEncoder;
import com.cos.dong_area_backend.dto.LoginRequestDto;
import com.cos.dong_area_backend.entity.User;
import com.cos.dong_area_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/join")
    @ResponseBody
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

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "WWW";
    }
}
