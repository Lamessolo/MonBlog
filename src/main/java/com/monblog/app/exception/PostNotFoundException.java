package com.monblog.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException {

	private String postName;
	private String fieldName;
	private String fieldValue;
	
	
	public PostNotFoundException(String postName, String fieldName, String fieldValue) {
		super(String.format("%s not found with %s : '%s'",postName, fieldName,fieldValue));
		this.postName = postName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}


	public String getPostName() {
		return postName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}


	
	
	
}
