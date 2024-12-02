package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payloads.CommentDto;
import com.example.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired 
	private CommentService commentService;
	 
	@PostMapping("/post/{postId}/create")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId){
		CommentDto creatCommentDto = this.commentService.createComment(commentDto, postId);
		return new ResponseEntity<CommentDto>(creatCommentDto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{commentId}")
	public ResponseEntity<?> deletComment(@PathVariable Integer commentId){
		this.commentService.deleteComment(commentId);
		return new ResponseEntity(Map.of("message","comment is deleted successfully"), HttpStatus.OK);
	}
	

}
