package com.springBoot.blogApplication.springbootBlogApplication.Exceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends Exception {
	@SuppressWarnings("unused")
	private String ResourceName;//which class(table)
	@SuppressWarnings("unused")
	private String fieldName;//which variable(column)
	@SuppressWarnings("unused")
	private String fieldValue;//the value passed
	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s not found with %s: '%s'", resourceName,fieldName,fieldValue));
		//post not found with id:1
		ResourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResourceName() {
		return ResourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	

}
