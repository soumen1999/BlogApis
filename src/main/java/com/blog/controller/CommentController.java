package com.blog.controller;

import com.blog.payload.CommentDto;
import com.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class CommentController {


    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //http://localhost:8080/api/posts/1/comments
    @PostMapping("/{postId}/comments")
    public ResponseEntity<CommentDto> saveComment(@PathVariable Long postId, @RequestBody CommentDto commentDto) {
        CommentDto savedCommentDto = commentService.createComment(postId, commentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCommentDto);
    }

    //http://localhost:8080/api/posts/1/comments
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") Long postId){
       return commentService.getCommentsByPostId(postId);
    }


    //http://localhost:8080/api/posts/1/comments/{1}
    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value =
            "postId") Long postId,
                                                     @PathVariable(value = "id") Long commentId){
        CommentDto commentDto = commentService.getCommentById(postId,
                commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }
}


