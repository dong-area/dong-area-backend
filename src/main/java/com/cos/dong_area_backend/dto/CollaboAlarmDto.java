package com.cos.dong_area_backend.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CollaboAlarmDto {
    private String writer;
    private String target;
}
