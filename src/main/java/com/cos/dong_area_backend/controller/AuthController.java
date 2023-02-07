package com.cos.dong_area_backend.controller;

import com.cos.dong_area_backend.config.encoder.PasswordEncoder;
import com.cos.dong_area_backend.dto.LoginDto;
import com.cos.dong_area_backend.entity.User;
import com.cos.dong_area_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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
    public String join(@RequestBody LoginDto loginDto) {
        loginDto.setPassword(passwordEncoder.encode(loginDto.getPassword()));
        User user = User.builder()
                .id(loginDto.getId())
                .password(loginDto.getPassword())
                .username(loginDto.getUsername())
                .roles("ROLE_USER")
                .stu_id(loginDto.getStu_id())
                .build();
        userRepository.save(user);
        return "succeed";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto){
        
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "WWW";
    }
}
