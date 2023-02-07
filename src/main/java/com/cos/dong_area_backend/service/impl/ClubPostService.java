package com.cos.dong_area_backend.service.impl;

import com.cos.dong_area_backend.dto.PostListResponseDto;
import com.cos.dong_area_backend.dto.PostWriteRequestDto;
import com.cos.dong_area_backend.entity.Post;
import com.cos.dong_area_backend.repository.PostRepository;
import com.cos.dong_area_backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClubPostService implements PostService {

    private final PostRepository postRepository;
    @Override
    public PostListResponseDto clubBoardList(int pageIndex) {
        PageRequest pageRequest = PageRequest.of(pageIndex,6);
        return PostListResponseDto.builder()
                .postPage(postRepository.findAll(pageRequest))
                .build();
    }

    @Override
    public void writeClubPost(PostWriteRequestDto writeRequest) {
        Post post = Post.builder()
                .title(writeRequest.getTitle())
                .context(writeRequest.getContext())
                .writer(writeRequest.getWriter())
                .build();
        postRepository.save(post);
    }
}
