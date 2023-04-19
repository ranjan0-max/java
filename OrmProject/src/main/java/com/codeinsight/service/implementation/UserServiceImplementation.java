package com.codeinsight.service.implementation;

import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeinsight.dao.UserDao;
import com.codeinsight.entity.Country;
import com.codeinsight.entity.State;
import com.codeinsight.entity.User;
import com.codeinsight.service.UserService;

@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	private UserDao userDao;

	@Transactional
	public List<User> getAllUser(Map<String, String> queryParameters) {
		List<User> userList = userDao.getAllUser(queryParameters);
		for(User user: userList) {
			user.setCountry(null);
			user.setState(null);
		}
		return userList;
	}
	
	@Transactional
	public User findUserById(Integer Id) {
		User user = userDao.findUserById(Id);
//		Country country = user.getCountry();
//		Hibernate.initialize(country);
//		State state = user.getState();
//		Hibernate.initialize(state);
		State state = (State) Hibernate.unproxy(user.getState());
		Country country = (Country) Hibernate.unproxy(user.getCountry());
		user.setCountry(country);
		user.setState(state);
		return user;
	}

	@Transactional
	public boolean deleteUser(Integer id) {
		boolean deleteUser = userDao.deleteUser(id);
		return deleteUser;
	}

	@Transactional
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Transactional
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
}
