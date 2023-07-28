package com.library.service;

import com.library.exception.ResourceDBException;
import com.library.model.User;

public interface LoginService {

	public User validateLogin(User user) throws ResourceDBException;

	public User logout(User user);
	
	public User getLogin(String email,String password);
}