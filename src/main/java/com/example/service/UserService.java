package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.payloads.UserDto;


public interface UserService {
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);
	
	UserDto registerNewUser(UserDto userDto);
	

}
