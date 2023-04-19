package com.codeinsight.service.implementation;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeinsight.dao.LogInDao;
import com.codeinsight.dao.UserDao;
import com.codeinsight.entity.Country;
import com.codeinsight.entity.LogIn;
import com.codeinsight.entity.State;
import com.codeinsight.entity.User;
import com.codeinsight.service.LogInService;

@Service
public class LogInServiceImplementation implements LogInService{
	
	@Autowired
	private LogInDao logInDao;
	@Autowired
	private UserDao userDao;

	@Transactional
	public boolean validateUser(LogIn logIn) {
		List<User> users = logInDao.validateUser(logIn);
		if(users.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Transactional
	public void deleteUser(Integer id) {
		boolean userDelete = userDao.deleteUser(id);
		if(userDelete) {
			System.out.println("user delete");
		} else {
			System.out.println("user not delete");
		}
	}

	@Transactional
	public User getUserById(Integer id) {
		User user = userDao.findUserById(id);
		State state = (State) Hibernate.unproxy(user.getState());
		Country country = (Country) Hibernate.unproxy(user.getCountry());
		user.setCountry(country);
		user.setState(state);
		return user;
	}

}
