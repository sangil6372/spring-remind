package com.example.springremind.web;


import com.example.springremind.service.posts.PostsService;
import com.example.springremind.web.dto.PostsResponseDto;
import com.example.springremind.web.dto.PostsSaveRequestDto;
import com.example.springremind.web.dto.PostsUpdateRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor // 생성자가 있으면 AutoWired 사용안해도 됨
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    // Entity 만 변경해도 테이블 내용이 변경됨
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @Operation(summary = "사용자 조회", description = "특정 사용자 목록을 반환합니다.")
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }


    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

}
