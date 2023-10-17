package com.monblog.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.monblog.app.dto.PostDto;
import com.monblog.app.entity.Post;
import com.monblog.app.repository.PostRepository;
import com.monblog.app.service.PostService;


@Service
public class PostServiceImpl implements PostService{

	private PostRepository postRepository;
	
	private ModelMapper mapper;
	
	public PostServiceImpl(PostRepository postRepository, ModelMapper mapper) {	
		this.postRepository = postRepository;
		this.mapper = mapper;
	}

	private PostDto mapEntityToDto(Post post) 
	{		
		return mapper.map(post, PostDto.class);
	}
	
	private Post mapDtoToEntity(PostDto postDto) 
	{		
		return mapper.map(postDto, Post.class);
	}
	
	
	@Override
	public PostDto createPost(PostDto postDto){
		Post newPost = mapDtoToEntity(postDto);
		postRepository.save(newPost);
		return mapEntityToDto(newPost) ;
	}

	@Override
	public List<PostDto> getAllPost() {
		
		List<Post> posts = postRepository.findAll();
				
		return  posts.stream().map(this::mapEntityToDto).collect(Collectors.toList());
	}

	
}
