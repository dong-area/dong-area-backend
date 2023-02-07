package com.cos.dong_area_backend.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Builder
public class PostWriteRequestDto {
    private String title;
    private String context;
    private String writer;
    @CreatedDate
    private LocalDateTime createdDate;
}
