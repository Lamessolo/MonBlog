package com.monblog.app.service;

import java.util.List;

import com.monblog.app.dto.PostDto;

public interface PostService {

	PostDto createPost(PostDto postDto);
	
	List<PostDto> getAllPost();
}
