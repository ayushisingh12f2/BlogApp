package com.example.service;

import java.util.List;

import com.example.entities.Category;
import com.example.entities.Post;
import com.example.entities.User;
import com.example.payloads.PostDto;
import com.example.payloads.PostResponse;

public interface PostService {
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	void deletePost(Integer PostId);
	
	PostResponse getAllPost(Integer pageNumber,Integer pageSize, String sortBy, String sortDir);
	
	PostDto getPostById(Integer PostId);
	
	List<PostDto> getPostsByCategory(Integer CategoryId);
	
	List<PostDto> getPostsByUser(Integer UserId);
	
	List<PostDto> serachPosts(String keyword);
	
	

}
