package com.cos.dong_area_backend.controller;

import com.cos.dong_area_backend.dto.PostListResponseDto;
import com.cos.dong_area_backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    @ResponseBody
    public PostListResponseDto pageList(@RequestParam(name = "name",defaultValue = "0")int index){
        return postService.boardList(index);
    }
}
