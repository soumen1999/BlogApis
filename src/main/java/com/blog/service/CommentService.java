package com.blog.service;

import com.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {
    public CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);
    CommentDto getCommentById(Long postId, Long commentId);
}
