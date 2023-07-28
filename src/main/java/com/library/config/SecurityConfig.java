package com.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
	
	
	 @Autowired
	    UserDetailsService userDetailsService;
     
	
	@Bean
	 public DaoAuthenticationProvider daoAuthenticationProvider()
	 {
		 DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		 provider.setUserDetailsService(this.userDetailsService);
		 provider.setPasswordEncoder(bCryptPasswordEncoder());
		return provider;
		 
	 }
	 @Bean
	 public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception
	 {
		 return configuration.getAuthenticationManager();
	 }
   @Bean
   public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
   {
	   httpSecurity.csrf().disable()
	   .authorizeRequests()
	   //role based authentication
	   .antMatchers("/api/addBook").hasAnyRole("ADMIN")
	   .antMatchers("/api/removeBook/{BookId}").hasAnyRole("ADMIN")
	   //.antMatchers("/api/viewBookByAuthor/{author}").hasAnyRole("ADMIN")
	   .antMatchers("/api/updateBook").hasAnyRole("ADMIN")
	   
	   
	   
	   
	   .antMatchers("/api")
	   .permitAll()
	   .anyRequest().authenticated()
	   .and().formLogin();
	   
	   return httpSecurity.build();
	   
   }
   /*@Bean
   public PasswordEncoder passwordEncoder() {
     return PasswordEncoderFactories.createDelegatingPasswordEncoder();
   }*/
   @Bean
   public BCryptPasswordEncoder bCryptPasswordEncoder() {
   	return new BCryptPasswordEncoder();
   }
   /*@Bean
   public UserDetailsService userDetailsService()
   {
	 
	  
	  UserDetails adminUser = User.withUsername("admin")
			  .password(passwordEncoder().encode("5678")).
			  roles("ADMIN").build();
	  
	  
	 
	  
	 return  new InMemoryUserDetailsManager(adminUser);
	   
   }*/
   
   
}


	
   