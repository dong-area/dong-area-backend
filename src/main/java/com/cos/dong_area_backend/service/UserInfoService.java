package com.cos.dong_area_backend.service;

import com.cos.dong_area_backend.dto.UserInfoResponseDto;
import com.cos.dong_area_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserRepository userRepository;

    public UserInfoResponseDto getUserInfo(){
        return null;
    }
}
