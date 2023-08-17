package com.springBoot.blogApplication.springbootBlogApplication.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;
@Service
public interface PostService {
	PostDTO creaPostDTO(PostDTO postDto);

	List<PostDTO> getAllPost();

	PostDTO getAllPostById(int id);

	public String deletepostbyid(int id);

	PostDTO updatePostByID(PostDTO p);

}
