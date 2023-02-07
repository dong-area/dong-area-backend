package com.cos.dong_area_backend.service;

import com.cos.dong_area_backend.dto.PostListResponseDto;
import com.cos.dong_area_backend.dto.PostWriteRequestDto;
import com.cos.dong_area_backend.entity.Post;
import com.cos.dong_area_backend.repository.PostRepository;
import org.springframework.stereotype.Service;

public interface PostService {
    public PostListResponseDto clubBoardList(int pageIndex);
    public void writeClubPost(PostWriteRequestDto writeRequest);
}
