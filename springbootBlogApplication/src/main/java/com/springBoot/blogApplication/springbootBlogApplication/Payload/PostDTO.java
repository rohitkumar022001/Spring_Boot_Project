package com.springBoot.blogApplication.springbootBlogApplication.Payload;

import java.util.List;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Data
public class PostDTO {
	long id;
	String title;
	String description;
	String content;
	String categorytitle;
	int uid;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	List<Comment> cmt;
	
	
	
	public List<Comment> getCmt() {
		return cmt;
	}
	public void setCmt(List<Comment> cmt) {
		this.cmt = cmt;
	}
	public String getCategorytitle() {
		return categorytitle;
	}
	public void setCategorytitle(String categorytitle) {
		this.categorytitle = categorytitle;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
