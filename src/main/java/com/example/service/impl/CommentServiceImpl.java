package com.example.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Comment;
import com.example.entities.Post;
import com.example.exceptions.ResourceNotFoundException;
import com.example.payloads.CommentDto;
import com.example.repository.CommentRepository;
import com.example.repository.PostRepository;
import com.example.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		Post post = this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post","id",postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment createdComment = this.commentRepository.save(comment);
	
		return this.modelMapper.map(createdComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = this.commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("comment", "id",commentId));
		this.commentRepository.delete(comment);;

	}

}
