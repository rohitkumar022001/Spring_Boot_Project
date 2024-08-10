package com.springBoot.blogApplication.springbootBlogApplication.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Comment;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.CommentDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;

@Service
public interface CommentService {

	

	CommentDTO createCommentDTO(CommentDTO cdto);

	List<CommentDTO> getAllComment();

	CommentDTO getAllCommentById(int cmtid);

	CommentDTO updateCommentByID(CommentDTO p);

	

	public String deletecommentbyid(int id);

//	Comment createComment(Comment comment);

	List<Comment> getCommentbyPostid(int id);



}
