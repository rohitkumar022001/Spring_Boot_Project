package com.springBoot.blogApplication.springbootBlogApplication.Exceptions;


public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
