package com.springBoot.blogApplication.springbootBlogApplication.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.blogApplication.springbootBlogApplication.Payload.CommentDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Service.CommentService;

@RestController
@RequestMapping("comment")
public class CommentController {
	private CommentService CommentService;

	public CommentController(CommentService commentService) {
		super();
		CommentService = commentService;
	}
	@PostMapping
	public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO cdto ){
		return new ResponseEntity<>(CommentService.createPostDTO(cdto), HttpStatus.CREATED);
	}
	
	

}
