package com.cos.dong_area_backend.controller;

import com.cos.dong_area_backend.dto.PostListResponseDto;
import com.cos.dong_area_backend.dto.PostWriteRequestDto;
import com.cos.dong_area_backend.service.impl.ClubPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/club/post")
@RequiredArgsConstructor
public class ClubPostController {

    private final ClubPostService postService;

    @GetMapping("/list")
    @ResponseBody
    public PostListResponseDto pageList(@RequestParam(name = "name",defaultValue = "0")int index){
        return postService.clubBoardList(index);
    }

    @PostMapping("/write")
    @ResponseBody
    public String writePost(@RequestBody PostWriteRequestDto postWriteRequestDto){
        postService.writeClubPost(postWriteRequestDto);
        return "uploading post succeed!";
    }
}
