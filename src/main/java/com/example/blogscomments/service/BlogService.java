package com.example.blogscomments.service;

import com.example.blogscomments.dto.BlogRequest;
import com.example.blogscomments.entity.Blog;
import com.example.blogscomments.exception.BlogNotFoundException;
import com.example.blogscomments.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Blog saveBlog(BlogRequest blogRequest) {

        Blog blog = Blog.build(
                0L,
                blogRequest.getTitle(),
                blogRequest.getContent()
        );


        return blogRepository.save(blog);

    }

    public Blog getBlogById(Long id) throws BlogNotFoundException {

        Blog blog = blogRepository.findById(id).orElse(null);

        if(blog != null) {
            return blog;
        } else {
            throw new BlogNotFoundException("Blog not found with ID: " + id);
        }

    }

    public boolean deleteBlogById(Long id) throws BlogNotFoundException {
        Blog blog = blogRepository.findById(id).orElse(null);

        if(blog != null) {
            blogRepository.deleteById(id);
            return true;
        } else {
            throw new BlogNotFoundException("Blog not found with ID: " + id);
        }
    }

    public Blog updateBlogById(BlogRequest blogRequest, Long id) throws BlogNotFoundException {

        Optional<Blog> blog = blogRepository.findById(id);

        Blog newBlog = null;

        if(blog.isPresent()) {

            newBlog = blog.get();

            newBlog.setId(id);
            newBlog.setTitle(blogRequest.getTitle());
            newBlog.setContent(blogRequest.getContent());

            blogRepository.save(newBlog);

        } else {
            throw new BlogNotFoundException("Blog not found with ID: " + id);
        }

        return newBlog;
    }
}

