package com.ktb.lukas.controller;

import com.ktb.lukas.api.ApiResponse;
import com.ktb.lukas.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts/{postId}/likes")
public class PostLikeController {
    private final PostLikeService postLikeService;

    @PostMapping
    public ApiResponse<Integer> insertLike(
            @PathVariable Long postId,
            @AuthenticationPrincipal Long userId
    )
    {
        int likeCount = postLikeService.insertLike(postId, userId);
        return ApiResponse.success("좋아요를 눌렀습니다.", likeCount);
    }

    @DeleteMapping
    public ApiResponse<Integer> deleteLike(
            @PathVariable Long postId,
            @AuthenticationPrincipal Long userId
    )
    {
        int likeCount = postLikeService.deleteLike(postId, userId);
        return ApiResponse.success("좋아요를 취소했습니다.", likeCount);
    }

}
