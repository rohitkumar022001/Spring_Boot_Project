package com.springBoot.blogApplication.springbootBlogApplication.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Comment;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.CommentDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
	private CommentService CommentService;

	public CommentController(CommentService commentService) {
		super();
		CommentService = commentService;
	}
	@PostMapping
	public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO cdto ){
		return new ResponseEntity<>(CommentService.createCommentDTO(cdto), HttpStatus.CREATED);
	}
	@GetMapping("getcomment")
	public ResponseEntity<List<CommentDTO>> getcomment() {
		return new ResponseEntity<>(CommentService.getAllComment(), HttpStatus.OK);

	}
	@GetMapping("getcomment/{cmtid}")
	public ResponseEntity<CommentDTO> getcommentbyid(@PathVariable int cmtid) {
		return new ResponseEntity<>(CommentService.getAllCommentById(cmtid), HttpStatus.OK);

	}
	@PutMapping("updatecomment")
	public ResponseEntity<CommentDTO> getcommentbyid(@RequestBody CommentDTO p) {
		return new ResponseEntity<>(CommentService.updateCommentByID(p), HttpStatus.OK);

	}
	@DeleteMapping("deletecomment/{id}")
	public ResponseEntity<String> deletecomment(@PathVariable int id){
		return new ResponseEntity<>(CommentService.deletecommentbyid(id),HttpStatus.OK);
	}
	@GetMapping("get/{id}")
	public ResponseEntity<List<Comment>> getCommentbyPostid(@PathVariable int id){
		return new ResponseEntity<List<Comment>>(CommentService.getCommentbyPostid(id),HttpStatus.OK);
	}
	

}
