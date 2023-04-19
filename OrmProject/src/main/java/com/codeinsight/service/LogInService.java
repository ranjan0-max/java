package com.codeinsight.service;

import com.codeinsight.entity.LogIn;
import com.codeinsight.entity.User;

public interface LogInService {
	
	public boolean validateUser(LogIn logIn);
	
	public void deleteUser(Integer id);
	
	public User getUserById(Integer id);

}
