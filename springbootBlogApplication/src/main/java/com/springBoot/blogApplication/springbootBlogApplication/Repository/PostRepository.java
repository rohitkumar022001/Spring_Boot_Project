package com.springBoot.blogApplication.springbootBlogApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;

public interface PostRepository extends JpaRepository<Posts, Long> {

	

	List<Posts> findAllByUid(int uid);

	
}
