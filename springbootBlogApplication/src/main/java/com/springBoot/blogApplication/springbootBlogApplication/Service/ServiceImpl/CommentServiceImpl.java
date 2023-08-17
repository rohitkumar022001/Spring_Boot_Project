package com.springBoot.blogApplication.springbootBlogApplication.Service.ServiceImpl;

import org.springframework.stereotype.Service;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Comment;
import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.CommentDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.CommentRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.PostRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {
	
	private CommentRepository CommentRepository;

	public CommentServiceImpl(CommentRepository CommentRepository) {
		super();
		this.CommentRepository = CommentRepository;
	}
	@Override
	public CommentDTO createPostDTO(CommentDTO cdto) {
		// TODO Auto-generated method stub
		Comment c=new Comment();
		c.setCmtid(cdto.getCmtid());
		c.setComment(cdto.getComment());
		c.setPostid(cdto.getPostid());
		Comment cmtdto=CommentRepository.save(c);
		CommentDTO cresp=new CommentDTO();
		cresp.setCmtid(cmtdto.getCmtid());
		cresp.setComment(cmtdto.getComment());
		cresp.setPostid(cmtdto.getPostid());
		return cresp;
	}
	

}
