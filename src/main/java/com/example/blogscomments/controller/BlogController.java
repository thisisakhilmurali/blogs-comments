package com.example.blogscomments.controller;

import com.example.blogscomments.dto.BlogRequest;
import com.example.blogscomments.entity.Blog;
import com.example.blogscomments.exception.BlogNotFoundException;
import com.example.blogscomments.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;


    @PostMapping("/addblog")
    public ResponseEntity<Blog> saveBlog(@RequestBody @Valid BlogRequest blogRequest) {
        return new ResponseEntity<>(blogService.saveBlog(blogRequest), HttpStatus.CREATED);
    }

    @GetMapping("/getblog/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) throws BlogNotFoundException {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> updateBlogById(@RequestBody @Valid BlogRequest blogRequest, @PathVariable Long id) throws BlogNotFoundException {
        return ResponseEntity.ok(blogService.updateBlogById(blogRequest, id));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteBlogById(@PathVariable Long id) throws BlogNotFoundException {
        return ResponseEntity.ok(blogService.deleteBlogById(id));
    }
}
