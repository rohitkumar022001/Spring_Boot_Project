package com.springBoot.blogApplication.springbootBlogApplication.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.PostRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Service.PostService;
@Service
public class PostServiceImpl implements PostService{
	private PostRepository PostRepository;

	public PostServiceImpl(PostRepository postRepository) {
		super();
		this.PostRepository = postRepository;
	}

	@Override
	public PostDTO creaPostDTO(PostDTO postDto) {
		// TODO Auto-generated method stub
		//postDTO converted to posts Entity
		Posts Posts=new Posts();
		Posts.setTitle(postDto.getTitle());
		Posts.setDescription(postDto.getDescription());
		Posts.setContent(postDto.getContent());
		Posts postsdto=PostRepository.save(Posts);
		//converting post Entity to postDTO
		PostDTO postResponse=new PostDTO();
		postResponse.setId(postsdto.getId());
		postResponse.setContent(postsdto.getContent());
		postResponse.setDescription(postsdto.getDescription());
		postResponse.setTitle(postsdto.getTitle());
		return postResponse;
	}

	@Override
	public List<PostDTO> getAllPost() {
		// TODO Auto-generated method stub
		List<Posts> l=PostRepository.findAll();
		List<PostDTO> p=new ArrayList<PostDTO>();
		for(Posts p1:l) {
			PostDTO pdto=new PostDTO();
			pdto.setContent(p1.getContent());
			pdto.setDescription(p1.getDescription());
			pdto.setTitle(p1.getTitle());
			pdto.setId(p1.getId());
			p.add(pdto);
		}
		return p;
	}

	@Override
	public PostDTO getAllPostById(int id) {
		Posts p1 = PostRepository.findById((long) id).get();
		PostDTO pdto=new PostDTO();
		pdto.setContent(p1.getContent());
		pdto.setDescription(p1.getDescription());
		pdto.setTitle(p1.getTitle());
		pdto.setId(p1.getId());
		return pdto;
	}
	@Override
	public PostDTO updatePostByID(PostDTO p) {

		Posts po = new Posts();

		po.setId(p.getId());

		po.setTitle(p.getTitle());

		po.setDescription(p.getDescription());

		po.setContent(p.getContent());

		PostRepository.save(po);

		return p;

	}
	
	public String deletepostbyid(int id) {
		PostRepository.deleteById((long) id);
		return "deleted";
	}

	

}
