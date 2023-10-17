package com.monblog.app.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monblog.app.entity.Post;
import com.monblog.app.repository.PostRepository;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class PostControllerIntegrationTest {

	   @Autowired
	    private MockMvc mockMvc;

	    @Autowired
	    private PostRepository postRepository;

	    @Autowired
	    private ObjectMapper objectMapper;
	    
	    @BeforeEach
	    void setup(){
	        postRepository.deleteAll();
	    }
	    
	    @Test
	    void givenPostObject_whenCreatePost_thenReturnSavedPost() throws Exception{

	        // given - precondition or setup
	        Post post = Post.builder()
	                .title("Test Unitaire Post")
	                .description("Test unitaire Pour Application Post")
	                .content("Test unitaire Pour Application Post")
	                .author("MESSOLO")
	                .imageUrl("images/posts/images.png")
	                .build();
	    
	        // when - action or behaviour that we are going test
	        ResultActions response = mockMvc.perform(post("/api/posts")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(objectMapper.writeValueAsString(post)));

	        // then - verify the result or output using assert statements
	        response.andDo(print()).
	                andExpect(status().isCreated())
	                .andExpect(jsonPath("$.title",
	                        is(post.getTitle())))
	                .andExpect(jsonPath("$.description",
	                        is(post.getDescription())))
	                .andExpect(jsonPath("$.content",
	                        is(post.getContent())));

	    }
	    
	    // JUnit test for Get All post REST API
	    @Test
	     void givenListOfPost_whenGetAllPost_thenReturnPostList() throws Exception{
	        // given - precondition or setup
	        List<Post> listOfPosts = new ArrayList<>();
	        listOfPosts.add(Post.builder().title("Test Get All Post").description("Test Get All Post").content("content Post").author("MBALA").build());
	        listOfPosts.add(Post.builder().title("Test Get 2 Posts").description("Test Get All Post").content("content Post").author("MESSOLO").build());
	        postRepository.saveAll(listOfPosts);
	        // when -  action or the behaviour that we are going test
	        ResultActions response = mockMvc.perform(get("/api/posts"));

	        // then - verify the output
	        response.andExpect(status().isOk())
	                .andDo(print())
	                .andExpect(jsonPath("$.size()",
	                        is(listOfPosts.size())));

	    }
	    
}
