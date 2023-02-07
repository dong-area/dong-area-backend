package com.cos.dong_area_backend.service;

import com.cos.dong_area_backend.entity.Post;
import com.cos.dong_area_backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    public Page<Post> boardList(int pageIndex) {
        PageRequest pageRequest = PageRequest.of(pageIndex,6);
        return postRepository.findAll(pageRequest);

    }
}