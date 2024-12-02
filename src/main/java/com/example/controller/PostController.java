package com.example.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.AppConstants;
import com.example.payloads.PostDto;
import com.example.payloads.PostResponse;
import com.example.service.FileService;
import com.example.service.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
//	@Autowired
//	private FileService fileService;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Integer userId, @PathVariable Integer categoryId){
		PostDto post = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<>(post,HttpStatus.CREATED);
	}
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
		List<PostDto> postDtos = this.postService.getPostsByCategory(categoryId);
		return new ResponseEntity(postDtos, HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
		List<PostDto> postDtos = this.postService.getPostsByUser(userId);
		return new ResponseEntity(postDtos, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<PostResponse> getAllPost(@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize ,
			@RequestParam(value = "sortBy" , defaultValue = AppConstants.SORT_BY , required = false) String sortBy,
			@RequestParam(value = "sortDir" , defaultValue = AppConstants.SORT_DIR, required = false) String sortDir){
		PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity(postResponse, HttpStatus.OK);
	}
	
	@GetMapping("/get/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		PostDto postDto = this.postService.getPostById(postId);
		return new ResponseEntity(postDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable Integer postId){
		this.postService.deletePost(postId);
		return new ResponseEntity(Map.of("mesage", "the post is deleted"),HttpStatus.OK);
	}
	
	//search
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>> searcgPost(@PathVariable String keywords){
		List<PostDto> result = this.postService.serachPosts(keywords);
		return new ResponseEntity<>(result , HttpStatus.OK);
	}
	
	//post image upload
}
