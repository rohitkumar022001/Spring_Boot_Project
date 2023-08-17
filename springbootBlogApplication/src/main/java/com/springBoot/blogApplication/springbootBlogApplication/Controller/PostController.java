package com.springBoot.blogApplication.springbootBlogApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Service.PostService;

@RestController
//@ResponseBody
//@Controller
@RequestMapping("/api/post")
public class PostController {
	// @Autowired
	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	@PostMapping
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO pdto) {

		return new ResponseEntity<>(postService.creaPostDTO(pdto), HttpStatus.CREATED);

	}

	@GetMapping("getpost")
	public ResponseEntity<List<PostDTO>> getpost() {
		return new ResponseEntity<>(postService.getAllPost(), HttpStatus.OK);

	}

	@GetMapping("getpost/{id}")
	public ResponseEntity<PostDTO> getpostbyid(@PathVariable int id) {
		return new ResponseEntity<>(postService.getAllPostById(id), HttpStatus.OK);

	}

	@PutMapping("updatepost")
	public ResponseEntity<PostDTO> getpostbyid(@RequestBody PostDTO p) {
		return new ResponseEntity<>(postService.updatePostByID(p), HttpStatus.OK);

	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deletepost(@PathVariable int id){
		return new ResponseEntity<>(postService.deletepostbyid(id),HttpStatus.OK);
	}
}
