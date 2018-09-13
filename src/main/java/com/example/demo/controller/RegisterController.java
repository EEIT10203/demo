package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.formbean.RegisterFormBean;
import com.example.demo.service.UserRegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserRegisterService service;
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index() {
    	return "redirect:/register/addUser";
    }
    
    @RequestMapping(value="/addUser", method = RequestMethod.GET)
    public String toAddUser() {
    	return "register";
    }
    
    @RequestMapping(value="/doAddUser", method = RequestMethod.POST)
    public String doAddUser(RegisterFormBean user) {
    	System.out.println("******RegisterFormBean:" + user);
    	service.createUser(user.getUser());
    	
        return "redirect:/";
    }
    
}
