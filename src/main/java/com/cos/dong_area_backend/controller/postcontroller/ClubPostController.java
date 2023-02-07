package com.cos.dong_area_backend.controller.postcontroller;

import com.cos.dong_area_backend.dto.PostListResponseDto;
import com.cos.dong_area_backend.dto.PostWriteRequestDto;
import com.cos.dong_area_backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/club/post")
@RequiredArgsConstructor
public class ClubPostController {

    private final PostService postService;

    @GetMapping("/list")
    @ResponseBody
    public PostListResponseDto pageList(){
        return postService.clubBoardList();
    }

    @PostMapping("/write")
    @ResponseBody
    public String writePost(@RequestBody PostWriteRequestDto postWriteRequestDto){
        postService.writeClubPost(postWriteRequestDto);
        return "uploading post succeed!";
    }
}
