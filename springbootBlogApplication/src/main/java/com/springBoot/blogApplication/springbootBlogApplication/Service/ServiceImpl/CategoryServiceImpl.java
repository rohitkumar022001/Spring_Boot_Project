package com.springBoot.blogApplication.springbootBlogApplication.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Category;
import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.CatDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.CategoryRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.PostRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Service.CategoryService;

import jakarta.persistence.CascadeType;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryrepository;
	@Override
	public CatDTO createCategory(CatDTO cdto) {
		// TODO Auto-generated method stub
		Category ct=new Category();
		ct.setCatid(cdto.getCatid());
		ct.setCatname(cdto.getCatname());
		ct.setPost(cdto.getPost());
		categoryrepository.save(ct);
		//converting post Entity to postDTO
		CatDTO catResponse=new CatDTO();
		catResponse.setCatid(ct.getCatid());
		catResponse.setCatname(ct.getCatname());
		catResponse.setPost(ct.getPost());
		
		return catResponse;
		
	}
	@Override
	public List<CatDTO> getall() {
		// TODO Auto-generated method stub
		List<Category> c=categoryrepository.findAll();
		List<CatDTO> cd=new ArrayList<CatDTO>();
		for(Category cat:c) {
			CatDTO cdto=new CatDTO();
			cdto.setCatid(cat.getCatid());
			cdto.setCatname(cat.getCatname());
			cdto.setPost(cat.getPost());
			cd.add(cdto);
		}
		return cd;
	}
	@Override
	public String delete(String catname) {
		// TODO Auto-generated method stub
		
		Category c=categoryrepository.findByCatname(catname);
		categoryrepository.deleteById(c.getCatid());
		return "Deleted";
	}
	
	
}
