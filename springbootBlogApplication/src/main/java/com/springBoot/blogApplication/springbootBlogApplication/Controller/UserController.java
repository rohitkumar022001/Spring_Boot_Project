package com.springBoot.blogApplication.springbootBlogApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;
import com.springBoot.blogApplication.springbootBlogApplication.Entity.User;
import com.springBoot.blogApplication.springbootBlogApplication.Exceptions.ResourceNotFoundException;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.ResourceNotFoundResponse;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.UserDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.UserRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Service.PostService;
import com.springBoot.blogApplication.springbootBlogApplication.Service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService UserService;
	@Autowired
	PostService PostService;
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
		return new ResponseEntity<>(UserService.createUser(user),HttpStatus.OK);
	}
	@GetMapping("getalluser")
	public ResponseEntity<List<UserDTO>> getuser(){
		return new ResponseEntity<List<UserDTO>>(UserService.getuser(),HttpStatus.OK);
	}
	@GetMapping("getpost/{uid}")
	public ResponseEntity<List<Posts>> getuserbyid(@PathVariable int uid){
		return new ResponseEntity<List<Posts>>(PostService.getuserbyid(uid),HttpStatus.OK);
	}
	
	@GetMapping("getuser/{uid}")
	public ResponseEntity<UserDTO> getuserbyuid(@PathVariable int uid){
		if(!UserService.checkUid(uid)) {
			throw new ResourceNotFoundException("User Id Not Found :"+uid);
		}
		return new ResponseEntity<UserDTO>(UserService.getuserbyuid(uid),HttpStatus.OK);
	}
	

	@ExceptionHandler
	public ResponseEntity<ResourceNotFoundResponse> resourceNotFoundError(ResourceNotFoundException exc){
		ResourceNotFoundResponse error = new ResourceNotFoundResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(),System.currentTimeMillis());
		
		return new ResponseEntity<ResourceNotFoundResponse>(error,HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler
	public ResponseEntity<ResourceNotFoundResponse> resourceNotFoundError(Exception exc){
		ResourceNotFoundResponse error = new ResourceNotFoundResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(),System.currentTimeMillis());
		
		return new ResponseEntity<ResourceNotFoundResponse>(error,HttpStatus.NOT_FOUND);
	}
	
}























