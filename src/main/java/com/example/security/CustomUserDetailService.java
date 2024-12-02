package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entities.User;
import com.example.exceptions.ResourceNotFoundException;
import com.example.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//loading user from database by username ( email )
		
		User user = this.userRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("user", "email "+ username, 0 ));
		
		
		
		return user;
	}

}
