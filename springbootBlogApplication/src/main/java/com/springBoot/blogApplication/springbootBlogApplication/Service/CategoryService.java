package com.springBoot.blogApplication.springbootBlogApplication.Service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Category;
import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.CatDTO;

@Service
public interface CategoryService {
	CatDTO createCategory(CatDTO cdto);
	List<CatDTO> getall();
	String delete(String catname);
	
}
