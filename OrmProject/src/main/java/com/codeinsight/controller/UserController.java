package com.codeinsight.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeinsight.entity.User;
import com.codeinsight.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> getAllUser(@RequestParam Map<String, String> queryParameters) {
		System.out.println(queryParameters);
		List<User> userList = userService.getAllUser(queryParameters);
		return userList;
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Integer id) {
		User user = userService.findUserById(id);
		return user;
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Integer id) {
		System.out.println("com");
		boolean deleteUser = userService.deleteUser(id);
		if (deleteUser) {
			System.out.println("user deleted");
		} else {
			System.out.println("user Not present");
		}
	}
	
	@PostMapping("/user")
	public void insertUser(@RequestBody User user) {
		userService.insertUser(user);
	}
	
	@PutMapping("/user")
	@CrossOrigin(origins="*")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}
}
