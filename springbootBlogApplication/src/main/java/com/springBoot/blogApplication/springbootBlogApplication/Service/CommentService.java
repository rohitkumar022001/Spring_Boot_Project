package com.springBoot.blogApplication.springbootBlogApplication.Service;

import org.springframework.stereotype.Service;

import com.springBoot.blogApplication.springbootBlogApplication.Payload.CommentDTO;

@Service
public interface CommentService {

	CommentDTO createPostDTO(CommentDTO cdto);

}
