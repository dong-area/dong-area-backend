package com.cos.dong_area_backend.dto;

import com.cos.dong_area_backend.entity.Post;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class PostListResponseDto {
    private Page<Post> postPage;
}
