package com.example;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.config.AppConstants;
import com.example.entities.Role;
import com.example.repository.RoleRepository;

@SpringBootApplication
public class BlogAppApplication {
	
//	implenets CommandLineRunner to used the method of the interface 
//	@Autowired
//	private PasswordEncoder passwordEncoder();
	
//	@Autowired
//	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(this.passwordEncoder("password given to the user during its creation"));
//		this.will generate the bcrypt password in reference to the password given to it.
	
//	try {
//		
//		Role role = new Role();
//		role.setId(AppConstants.ADMIN_USER);
//		role.setName("ADMIN_USER");
//		
//		
//		Role role1 = new Role();
//		role.setId(AppConstants.NORMAL_USER);
//		role.setName("NORMAL_USER");
//		
//		List<Role> roles = List.of(role,role1);
//		
//		List<Role> result = this.roleRepository.saveAll(roles);
//		
//		result.forEach( r -> {
//			System.out.println(r.getName());
//			
//		});
//		
//	}catch (Exception e){
//		
//		e.printStackTrace();
//	}
//	}

}
