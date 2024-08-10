package com.springBoot.blogApplication.springbootBlogApplication.Service.ServiceImpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Comment;
import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.CommentDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.CommentRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.PostRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired private CommentRepository CommentRepository;
	@Autowired
	private PostRepository prepo;

	public CommentServiceImpl(CommentRepository CommentRepository) {
		super();
		this.CommentRepository = CommentRepository;
	}
	@Override
	public CommentDTO createCommentDTO(CommentDTO cdto) {
		// TODO Auto-generated method stub
		Comment c=new Comment();
		c.setCmtid(cdto.getCmtid());
		c.setComment(cdto.getComment());
		c.setPostid(cdto.getPostid());
		try {
		Posts p = prepo.findById((long)cdto.getPostid()).get();
		List<Comment> lcmt = p.getComment();
		lcmt.add(c);
		p.setComment(lcmt);
		prepo.save(p);
		
		CommentDTO cresp=new CommentDTO();
		cresp.setCmtid(c.getCmtid());
		cresp.setComment(c.getComment());
		cresp.setPostid(c.getPostid());
		return cresp;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
		
	}
	@Override
	public List<CommentDTO> getAllComment() {
		// TODO Auto-generated method stub
		try {
		List<Comment> l=CommentRepository.findAll();
		List<CommentDTO> p=new ArrayList<CommentDTO>();
		for(Comment p1:l) {
			CommentDTO cdto=new CommentDTO();
			cdto.setComment(p1.getComment());
			cdto.setCmtid(p1.getCmtid());
			cdto.setPostid(p1.getPostid());
			cdto.setComment(p1.getComment());
			p.add(cdto);
		}
		return p;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public CommentDTO getAllCommentById(int cmtid) {
		try {
		Comment p1 = CommentRepository.findById(cmtid).get();
		CommentDTO cdto=new CommentDTO();
		cdto.setComment(p1.getComment());
		cdto.setCmtid(p1.getCmtid());
		cdto.setPostid(p1.getPostid());
		return cdto;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public CommentDTO updateCommentByID(CommentDTO p) {
		// TODO Auto-generated method stub
		Comment co = new Comment();

		co.setPostid(p.getPostid());

		co.setComment(p.getComment());

		co.setCmtid(p.getCmtid());

		CommentRepository.save(co);

		return p;

	}
	public String deletecommentbyid(int cmtid) {
		Comment c=CommentRepository.findById(cmtid).get();
		Posts p=prepo.findById((long) c.getPostid()).get();
		
		List<Comment> comment=p.getComment();
		for(Comment c1:comment) {
			if(c1.getCmtid()==cmtid) {
				comment.remove(c1);
				break;
			}
		}
		p.setComment(comment);
		prepo.save(p);
		CommentRepository.deleteById(cmtid);
		return "deleted";
	}
//	@Override
//	public Comment createComment(Comment comment) {
//		Posts p = prepo.findById((long)comment.getPostid()).get();
//		List<Comment> cmt = p.getComment();
//		cmt.add(comment);
//		p.setComment(cmt);
//		prepo.save(p);
//		
//		
//		return comment;
//	}
	@Override
	public List<Comment> getCommentbyPostid(int id) {
		
		
		return prepo.findById((long)id).get().getComment();
	}
	
	

}
