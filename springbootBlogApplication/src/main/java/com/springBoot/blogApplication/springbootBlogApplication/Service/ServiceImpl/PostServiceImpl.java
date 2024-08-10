package com.springBoot.blogApplication.springbootBlogApplication.Service.ServiceImpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Category;
import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;
import com.springBoot.blogApplication.springbootBlogApplication.Entity.User;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.CatDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.CategoryRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.PostRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.UserRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Service.PostService;
@Service
public class PostServiceImpl implements PostService{
	private PostRepository PostRepository;

	public PostServiceImpl(PostRepository postRepository) {
		super();
		this.PostRepository = postRepository;
	}
	@Autowired
	private CategoryRepository crepo;
	@Autowired
	private UserRepository Userrepository;
	CatDTO cd;
	@Override
	public PostDTO creaPostDTO(PostDTO postDto) {
		
		//postDTO converted to posts Entity
		
		Posts p=new Posts();
		p.setUid(postDto.getUid());
		p.setTitle(postDto.getTitle());
		p.setDescription(postDto.getDescription());
		p.setContent(postDto.getContent());
		p.setCategorytitle(postDto.getCategorytitle());
		p.setComment(postDto.getCmt());
		
		
		User u;
		try {
		u=Userrepository.findById(postDto.getUid()).get();
		}catch(Exception e) {
			return null;
		}
		
		
		Category c=crepo.findByCatname(postDto.getCategorytitle());
		if(c==null) {
			c = new Category();
			c.setCatname(p.getCategorytitle());
			List<Posts> l = new ArrayList<>();
			l.add(p);
			c.setPost(l);
			
		}
		else {
			List<Posts> lpost = c.getPost();
			lpost.add(p);
			c.setPost(lpost);
			
			
		}
		crepo.save(c);
		PostRepository.save(p);
		
		PostDTO postResponse=new PostDTO();
		postResponse.setId(p.getId());
		postResponse.setContent(p.getContent());
		postResponse.setDescription(p.getDescription());
		postResponse.setTitle(p.getTitle());
		postResponse.setCategorytitle(p.getCategorytitle());
		postResponse.setCmt(p.getComment());
		postResponse.setUid(p.getUid());
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
			pdto.setCategorytitle(p1.getCategorytitle());
			pdto.setCmt(p1.getComment());
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
		pdto.setCategorytitle(p1.getCategorytitle());
		pdto.setCmt(p1.getComment());
		return pdto;
	}
	@Override
	public PostDTO updatePostByID(PostDTO p) {

		Posts po = new Posts();

		po.setId(p.getId());

		po.setTitle(p.getTitle());

		po.setDescription(p.getDescription());

		po.setContent(p.getContent());
		po.setCategorytitle(p.getCategorytitle());
		po.setComment(p.getCmt());

		PostRepository.save(po);

		return p;

	}
	
	public String deletepostByid(int id) {
		Posts p1 = PostRepository.findById((long) id).get();
		Category c1 = crepo.findByCatname(p1.getCategorytitle());
		List<Posts> p=c1.getPost();
		for(Posts p2: p) {
			if(p2.getId()==(long) id){
			p.remove(p1);
			break;
			}
			
		}
		c1.setPost(p);
		crepo.save(c1);
		PostRepository.deleteById((long)id);
		return "deleted";
	}

	@Override
	public List<Posts> getuserbyid(int uid) {
		// TODO Auto-generated method stub
		List<Posts> p=PostRepository.findAllByUid(uid);
		return p;
	}

	
	

	

}
