package com.cos.dong_area_backend.controller.postcontroller;

import com.cos.dong_area_backend.dto.PostListResponseDto;
import com.cos.dong_area_backend.dto.PostWriteRequestDto;
import com.cos.dong_area_backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project/post")
@RequiredArgsConstructor
public class ProjectPostController {

    private final PostService postService;

    @GetMapping("/list")
    @ResponseBody
    public PostListResponseDto pageList(){
        return postService.projectBoardList();
    }

    @PostMapping("/write")
    @ResponseBody
    public String writePost(@RequestBody PostWriteRequestDto postWriteRequestDto){
        postService.writeProjectPost(postWriteRequestDto);
        return "uploading post succeed!";
    }
}
