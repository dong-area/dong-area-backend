package com.cos.dong_area_backend.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserInfoResponseDto {
    private String id;
    private String password;
    private String stu_id;
    private String username;
    private String clubname;

}
