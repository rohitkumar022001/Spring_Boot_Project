package com.springBoot.blogApplication.springbootBlogApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
