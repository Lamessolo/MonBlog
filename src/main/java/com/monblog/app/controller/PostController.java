package com.monblog.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monblog.app.dto.PostDto;
import com.monblog.app.service.PostService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/posts")
@CrossOrigin("*")
public class PostController {

	
	private PostService postService;
	
	
	public PostController(PostService postService) {
		this.postService = postService;	
	}
	
	@PostMapping
	@Operation(summary = "Create Post", description = "This endpoint create a Post") // Documentation Swagger
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
		
		try {
			 
			return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
		}catch(Exception e) {
			  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);}
		}
	

	@GetMapping
	@Operation(summary = "Get All Posts", description = "This endpoint retrieve all posts")
	public List<PostDto> getAllPosts(){
			return postService.getAllPost();		
	}
}
