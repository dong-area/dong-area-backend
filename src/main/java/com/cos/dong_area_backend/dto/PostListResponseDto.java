package com.cos.dong_area_backend.dto;

import com.cos.dong_area_backend.entity.Post;
import lombok.*;
import org.springframework.data.domain.Page;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PostListResponseDto {
    private Page<Post> postPage;
}
