package com.cos.dong_area_backend.dto;

import com.cos.dong_area_backend.entity.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoginRequestDto {
    private String id;
    private String password;
    private String username;
    private String stu_id;
    private String clubname;

    public User toEntity(){
        User user = User.builder()
                .id(id)
                .password(password)
                .username(username)
                .clubname(clubname)
                .stu_id(stu_id)
                .build();
        return user;
    }

}
