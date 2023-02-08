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
    public PostListResponseDto clubBoardList() {
        PageRequest pageRequest = PageRequest.of(0,10000);
        System.out.println("club 에서 페이지 불러옴");
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
                .image_url(writeRequest.getImage_url())
                .build();
        postRepository.save(post);
        System.out.println("club 에서 페이지 저장함");
    }

    public PostListResponseDto projectBoardList() {
        PageRequest pageRequest = PageRequest.of(0,10000);
        System.out.println("project 에서 페이지 불러옴");
        return PostListResponseDto.builder()
                .postPage(postRepository.findAllByType("project",pageRequest))
                .build();
    }
    public void writeProjectPost(PostWriteRequestDto writeRequest){
        System.out.println("projectWrite");
        Post post = Post.builder()
                .title(writeRequest.getTitle())
                .context(writeRequest.getContext())
                .writer(writeRequest.getWriter())
                .type("project")
                .image_url(writeRequest.getImage_url())
                .build();
        postRepository.save(post);
        System.out.println("project 에서 페이지 저장함");
    }

    public PostListResponseDto authedBoardList() {
        PageRequest pageRequest = PageRequest.of(0,10000);
        System.out.println("내 동아리 에서 페이지 불러옴");
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
                .image_url(writeRequest.getImage_url())
                .build();
        postRepository.save(post);
        System.out.println("내 동아리 에서 페이지 저장함");
    }

}
