package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.example.demo.entity.TUser;
import com.example.demo.repository.TUserRepository;

@Component
public class CurrentUser {

	@Autowired
	private TUserRepository repository;
	
	public String getUserId() {
		try {
			User user =(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return user.getUsername();
			
		} catch (Exception e) {
			return "";
		}

	}
	
	public String getUserName() {
		TUser user = repository.getById(getUserId());
		return user.getUserName();
	}
	
	public String getUserRole() {
		TUser user = repository.getById(getUserId());
		return user.getRole();
	}
}
