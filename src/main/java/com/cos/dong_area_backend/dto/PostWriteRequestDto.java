package com.cos.dong_area_backend.dto;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PostWriteRequestDto {
    private String title;
    private String context;
    private String writer;
    private String type;
}
