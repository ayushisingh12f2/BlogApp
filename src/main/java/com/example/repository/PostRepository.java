package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Category;
import com.example.entities.Post;
import com.example.entities.User;

public interface PostRepository extends JpaRepository<Post,Integer>{
	
	//custom finder methods named ina certain way to get the data
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	List<Post> findByPostTitleContaining(String postTitle);
	

}
