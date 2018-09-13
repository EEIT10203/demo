package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TUser;
import com.example.demo.repository.TUserRepository;

@Service
public class UserRegisterService {

	@Autowired
	private TUserRepository userRepository;
	
	public void createUser(TUser user) {
		user.setStatus("1");
		user.setRole("U");
		this.userRepository.save(user);
	}
	
	public void updateUser(TUser user) {
		this.userRepository.save(user);
	}
}
