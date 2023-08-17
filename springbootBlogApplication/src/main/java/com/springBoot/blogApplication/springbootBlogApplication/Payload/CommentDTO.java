package com.springBoot.blogApplication.springbootBlogApplication.Payload;

public class CommentDTO {
	int cmtid;
	String comment;
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
