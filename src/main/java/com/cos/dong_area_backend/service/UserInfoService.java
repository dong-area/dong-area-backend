package com.cos.dong_area_backend.service;

import com.cos.dong_area_backend.config.encoder.PasswordEncoder;
import com.cos.dong_area_backend.dto.UserInfoResponseDto;
import com.cos.dong_area_backend.entity.User;
import com.cos.dong_area_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserInfoResponseDto getUserInfo(String username){
       User user =  userRepository.findByUsername(username);
        return UserInfoResponseDto.builder()
                .id(user.getId())
                .password(user.getPassword())
                .username(user.getUsername())
                .stu_id(user.getStu_id())
                .clubname(user.getClubname())
                .build();
    }
}
