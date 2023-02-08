package com.cos.dong_area_backend.dto;

import com.cos.dong_area_backend.entity.Alarm;
import lombok.*;

import java.util.List;

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
    private List<Alarm> alarm;

}
