package com.springBoot.blogApplication.springbootBlogApplication.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comment {
	@Id
	@GeneratedValue(
		strategy=GenerationType.IDENTITY
	)
	int cmtid;
	@Column(name="comment",nullable = false)
	String comment;
	@Column(name="postid",nullable = false)
	int postid;
	public int getCmtid() {
		return cmtid;
	}
	public void setCmtid(int cmtid) {
		this.cmtid = cmtid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}

}
