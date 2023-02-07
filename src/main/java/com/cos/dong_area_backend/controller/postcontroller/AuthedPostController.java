package com.cos.dong_area_backend.controller.postcontroller;

import com.cos.dong_area_backend.dto.PostListResponseDto;
import com.cos.dong_area_backend.dto.PostWriteRequestDto;
import com.cos.dong_area_backend.entity.Post;
import com.cos.dong_area_backend.repository.PostRepository;
import com.cos.dong_area_backend.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authed/post")
@Tag(name = "'게시판'",description = "3개의 컨트롤러로 분리된 게시판 관리")
public class AuthedPostController {

    private final PostService postService;

    @GetMapping("/list")
    @ResponseBody
    @Operation(summary = "게시판 불러오기(내 동아리)")
    public PostListResponseDto pageList(){
        return postService.authedBoardList();
    }

    @PostMapping("/write")
    @ResponseBody
    @Operation(summary = "게시판 작성하기(내 동아리)")
    public String writePost(@RequestBody PostWriteRequestDto postWriteRequestDto){
        postService.writeAuthedPost(postWriteRequestDto);
        return "uploading post succeed!";
    }
}
