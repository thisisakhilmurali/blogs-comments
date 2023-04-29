package com.example.blogscomments.service;

import com.example.blogscomments.dto.CommentRequest;
import com.example.blogscomments.entity.Blog;
import com.example.blogscomments.entity.Comment;
import com.example.blogscomments.exception.BlogNotFoundException;
import com.example.blogscomments.repository.BlogRepository;
import com.example.blogscomments.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BlogRepository blogRepository;

    public Comment addComment(CommentRequest commentRequest) throws BlogNotFoundException {

        Blog blog = blogRepository.findById(commentRequest.getBlogId()).orElse(null);

        if(blog != null) {

            Comment comment = Comment.build(
                    0L,
                    commentRequest.getBlogId(),
                    commentRequest.getComment()
            );

            return commentRepository.save(comment);

        } else {
            throw new BlogNotFoundException("Blog not found with ID: " + commentRequest.getBlogId());
        }

    }
}
