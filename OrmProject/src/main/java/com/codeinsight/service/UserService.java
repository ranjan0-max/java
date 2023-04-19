package com.codeinsight.service;

import java.util.List;
import java.util.Map;

import com.codeinsight.entity.User;

public interface UserService {

	public List<User> getAllUser(Map<String, String> queryParameters);
	
	public User findUserById(Integer id);
	
	public boolean deleteUser(Integer id);
	
	public void insertUser(User user);
	
	public void updateUser(User user);
}
