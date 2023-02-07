package com.cos.dong_area_backend.service;

import com.cos.dong_area_backend.dto.ClubInfoResponseDto;
import com.cos.dong_area_backend.entity.Club;
import com.cos.dong_area_backend.entity.User;
import com.cos.dong_area_backend.repository.ClubRepository;
import com.cos.dong_area_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubInfoService {
    private final ClubRepository clubRepository;
    private final UserRepository userRepository;

    public ClubInfoResponseDto loadClubInfo(String username){

        String clubname = userRepository.findByUsername(username).getClubname();
        Club club = clubRepository.findByName(clubname);
        List<String> members = userRepository.findAllUsernameByClubname(clubname);

        return ClubInfoResponseDto.builder()
                .name(club.getName())
                .description(club.getDescription())
                .logo_url(club.getLogo_url())
                .manager(club.getManager())
                .members(members)
                .build();
    }
}
