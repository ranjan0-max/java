package com.codeinsight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeinsight.entity.LogIn;
import com.codeinsight.entity.User;
import com.codeinsight.service.LogInService;

@RestController
public class logInController {
	
	@Autowired
	private LogInService logInService;

	@PostMapping("/login")
	public boolean validateUser(@RequestBody LogIn logIn) {
		System.out.println(logIn.getEmail()+logIn.getPassword());
		return logInService.validateUser(logIn);
	}
	
	@DeleteMapping("/login/{id}")
	@CrossOrigin(origins="*")
	public void deleteUser(@PathVariable Integer id) {
		logInService.deleteUser(id);
	}
	
	@GetMapping("/login/{id}")
	@CrossOrigin(origins="*")
	public User getUserById(@PathVariable Integer id) {
		User user = logInService.getUserById(id);
		return user;
	}
}
