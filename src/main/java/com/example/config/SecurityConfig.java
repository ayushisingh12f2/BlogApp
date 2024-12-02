//package com.example.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//
////			basic authentication
//
//@Configuration 	//this annotation define that this is configuration class so that we can declare bean 
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)  //to provide the security to every method
//public class SecurityConfig extends WebSecurityConfiguration{
//	
//	@Autowired
//	private CustomUserDeatilService customUcerDetailService;
//
//	@Bean(name = customConfigure)
//	protected void configure(HttpSecurity http) throws Exception{
//		
//		http.
//		csrf().disable()
//		.authorizeHttpRequests().antMatchers("api/v1/auth/**").permitAll()
//		.anyRequest()
//		.authenticated()
//		.and()
//		.exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint).and()
//		.sessionManagement().sessionCrearionPolicy(SessionCreationPolicy.STATELESS);

//		http.addFilterBefore(this.jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
//	}
//	
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(this.customUserDetailsService).passwordEncoder(passwordEncoder());
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncpder(); // used for bcrypting the password which is set in database before it is used
//	}
//
//	public AuthenticationManager authenticationManagerBean() throws Exception{
//		return super.authenticationManagerBean();
//	}
//}
