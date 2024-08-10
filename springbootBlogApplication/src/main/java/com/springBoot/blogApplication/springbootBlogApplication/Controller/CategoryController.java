package com.springBoot.blogApplication.springbootBlogApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Category;
import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.CatDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Service.CategoryService;
import com.springBoot.blogApplication.springbootBlogApplication.Service.PostService;

@RestController
@RequestMapping("category")
public class CategoryController {
	@Autowired
	private CategoryService categoryservice;
	@Autowired
	private PostService postservice;
	
	@PostMapping("create")
	public ResponseEntity<CatDTO> createCategory(@RequestBody CatDTO cdto){
		return new ResponseEntity<>(categoryservice.createCategory(cdto),HttpStatus.CREATED);
	}
	@DeleteMapping("delete/{catname}")
	public ResponseEntity<String> delete(@PathVariable String catname){
		return new ResponseEntity<>(categoryservice.delete(catname),HttpStatus.CREATED);
	}
	
	
	
}
