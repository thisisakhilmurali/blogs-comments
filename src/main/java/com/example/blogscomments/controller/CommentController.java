package com.example.blogscomments.controller;

import com.example.blogscomments.dto.CommentRequest;
import com.example.blogscomments.entity.Comment;
import com.example.blogscomments.exception.BlogNotFoundException;
import com.example.blogscomments.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blogs")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comment")
    public ResponseEntity<Comment> addComment(@RequestBody @Valid CommentRequest commentRequest) throws BlogNotFoundException {
        return new ResponseEntity<>(commentService.addComment(commentRequest), HttpStatus.CREATED);
    }


}
