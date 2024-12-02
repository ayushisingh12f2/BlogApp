package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payloads.UserDto;
import com.example.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.OK);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> allUser = this.userService.getAllUsers();
		return new ResponseEntity<>(allUser, HttpStatus.OK);
	}
	
	@GetMapping("/get/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
		UserDto userById = this.userService.getUserById(userId);
		return new ResponseEntity<>(userById, HttpStatus.OK);
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable Integer userId){
		UserDto updateUserDto = this.userService.updateUser(userDto, userId);
		return new ResponseEntity<>(updateUserDto,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/delete/{userId}")
	@PreAuthorize("hasRole('ADMIN')")	// only admin can perform this operation
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
		this.userService.deleteUser(userId);
		return new ResponseEntity(Map.of("message", "user is deleted"),HttpStatus.OK);
	}
	
	

}
