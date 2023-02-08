package com.cos.dong_area_backend.controller;

import com.cos.dong_area_backend.entity.Club;
import com.cos.dong_area_backend.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final ClubRepository clubRepository;
    @PostMapping("/addClub")
    public String addClub(@RequestBody Club club){
        clubRepository.save(club);
        return "succeed";
    }
}
