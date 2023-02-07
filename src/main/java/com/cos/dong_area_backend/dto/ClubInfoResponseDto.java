package com.cos.dong_area_backend.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ClubInfoResponseDto {
    private String name;
    private String description;
    private String manager;
    private String logo_url;
    private List<String> members;
}