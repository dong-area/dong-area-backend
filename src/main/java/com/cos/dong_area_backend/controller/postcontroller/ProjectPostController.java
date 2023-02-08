package com.cos.dong_area_backend.controller.postcontroller;

import com.cos.dong_area_backend.dto.PostListResponseDto;
import com.cos.dong_area_backend.dto.PostWriteRequestDto;
import com.cos.dong_area_backend.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project/post")
@RequiredArgsConstructor
@Tag(name = "'게시판'",description = "3개의 컨트롤러로 분리된 게시판 관리")
public class ProjectPostController {

    private final PostService postService;

    @GetMapping("/list")
    @Operation(summary = "게시판 불러오기(프로젝트)")
    public PostListResponseDto pageList(){
        return postService.projectBoardList();
    }

    @PostMapping("/write")
    @Operation(summary = "게시판 작성하기(프로젝트)")
    public String writePost(@RequestBody PostWriteRequestDto postWriteRequestDto){
        System.out.println("project write post");
        postService.writeProjectPost(postWriteRequestDto);
        return "uploading post succeed!";
    }
}
