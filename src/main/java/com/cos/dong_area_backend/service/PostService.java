package com.cos.dong_area_backend.service;

import com.cos.dong_area_backend.dto.PostListResponseDto;
import com.cos.dong_area_backend.dto.PostWriteRequestDto;
import com.cos.dong_area_backend.entity.Post;
import com.cos.dong_area_backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    public PostListResponseDto clubBoardList(int pageIndex) {
        PageRequest pageRequest = PageRequest.of(pageIndex,10000);
        return PostListResponseDto.builder()
                .postPage(postRepository.findAllByType("club",pageRequest))
                .build();
    }
    public void writeClubPost(PostWriteRequestDto writeRequest){
        Post post = Post.builder()
                .title(writeRequest.getTitle())
                .context(writeRequest.getContext())
                .writer(writeRequest.getWriter())
                .type("club")
                .build();
        postRepository.save(post);
    }

    public PostListResponseDto projectBoardList(int pageIndex) {
        PageRequest pageRequest = PageRequest.of(pageIndex,10000);
        return PostListResponseDto.builder()
                .postPage(postRepository.findAllByType("project",pageRequest))
                .build();
    }
    public void writeProjectPost(PostWriteRequestDto writeRequest){
        Post post = Post.builder()
                .title(writeRequest.getTitle())
                .context(writeRequest.getContext())
                .writer(writeRequest.getWriter())
                .type("project")
                .build();
        postRepository.save(post);
    }

    public PostListResponseDto authedBoardList(int pageIndex) {
        PageRequest pageRequest = PageRequest.of(pageIndex,10000);
        return PostListResponseDto.builder()
                .postPage(postRepository.findAllByType("authed",pageRequest))
                .build();
    }
    public void writeAuthedPost(PostWriteRequestDto writeRequest){
        Post post = Post.builder()
                .title(writeRequest.getTitle())
                .context(writeRequest.getContext())
                .writer(writeRequest.getWriter())
                .type("authed")
                .build();
        postRepository.save(post);
    }

}
