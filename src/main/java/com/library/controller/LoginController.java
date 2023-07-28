package com.library.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.exception.ResourceDBException;
import com.library.model.User;
import com.library.repository.LoginRepository;
import com.library.service.LoginService;
@RestController
@RequestMapping("/api")
public class LoginController {
	Logger logger=org.slf4j.LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private LoginService service;
	@Autowired
	private LoginRepository logrepos;
	//login
	@PostMapping(path="/validateUser")
	public ResponseEntity<User> validateLogin(@RequestBody User user)throws ResourceDBException{
		logger.info("User login Success");
		return new ResponseEntity<User>(service.validateLogin(user),HttpStatus.OK);
	}

	/*@PutMapping("/signOut/{id}") 
	public User logout(@RequestBody User user) {
		return service.logout(user);
	}*/
	
	@GetMapping(path="/logout/{userid}")
	public User logout(@PathVariable int userid) {
		User u=logrepos.findById(userid).get();
		logger.info("User logout successfully");
		return service.logout(u);
	}
	@GetMapping(path="user/login/{email}/{password}")
	public User getLogin(@PathVariable String email,@PathVariable String password) {
		return service.getLogin(email, password);
	}
	
	
}
	
