package com.cos.dong_area_backend.controller.postcontroller;

import com.cos.dong_area_backend.dto.PostListResponseDto;
import com.cos.dong_area_backend.dto.PostWriteRequestDto;
import com.cos.dong_area_backend.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/club/post")
@RequiredArgsConstructor
@Tag(name = "'게시판'",description = "3개의 컨트롤러로 분리된 게시판 관리")
public class ClubPostController {

    private final PostService postService;

    @GetMapping("/list")
    @ResponseBody
    @Operation(summary = "게시판 불러오기(동아리 기획)")
    public PostListResponseDto pageList(){
        return postService.clubBoardList();
    }

    @PostMapping("/write")
    @ResponseBody
    @Operation(summary = "게시판 작성하기(동아리 기획)")
    public String writePost(@RequestBody PostWriteRequestDto postWriteRequestDto){
        System.out.println("write dto club");
        postService.writeClubPost(postWriteRequestDto);
        return "uploading post succeed!";
    }
    @GetMapping("/delete")
    public String deletePost(@RequestParam("idx")Long idx,@RequestParam("username")String username){
        return postService.deletePost(idx, username);
    }
}
