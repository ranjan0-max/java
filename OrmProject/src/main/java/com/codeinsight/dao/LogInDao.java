package com.codeinsight.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codeinsight.entity.LogIn;
import com.codeinsight.entity.User;

@Repository
public class LogInDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<User> validateUser(LogIn logIn) {
		Session session = sessionFactory.getCurrentSession();
		String query = "FROM User WHERE email=:email AND password =:password";
		Query<User> finalQuery = session.createQuery(query, User.class);
		finalQuery.setParameter("email", logIn.getEmail());
		finalQuery.setParameter("password", logIn.getPassword());
		List<User> users = finalQuery.getResultList();
		return users;		
	}
}
