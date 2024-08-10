package com.springBoot.blogApplication.springbootBlogApplication.Payload;

import java.util.List;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CatDTO {
	@Id
	@GeneratedValue(
			strategy=GenerationType.IDENTITY
		)
	int catid;
	String catname;
	List<Posts> post;
	public List<Posts> getPost() {
		return post;
	}
	public void setPost(List<Posts> post) {
		this.post = post;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	
}
