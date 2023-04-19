package com.codeinsight.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codeinsight.entity.User;

@Repository
public class UserDao {

	private final String AND = " AND ";
	private final String SPACE = " ";
	private final String SYNTAX = "= :";

	@Autowired
	private SessionFactory sessionFactory;

	public void insertUser(User user) {
		sessionFactory.getCurrentSession().save(user);

	}

	public List<User> getAllUser(Map<String, String> queryParameters) {
		Session session = sessionFactory.getCurrentSession();
		
		if (queryParameters.isEmpty()) {
			return session.createQuery("FROM User", User.class).list();
		} else {
			String query = "FROM User WHERE";
			Integer count = 0;

			for (Entry<String, String> parameter : queryParameters.entrySet()) {
				String key = parameter.getKey();
				if (count > 0) {
					query = query + AND;
				}
				query = query + SPACE + key + SYNTAX + key;
				count++;
			}

			Query<User> finalQuery = session.createQuery(query, User.class);

			for (Entry<String, String> parameter : queryParameters.entrySet()) {
				String key = parameter.getKey();
				String value = parameter.getValue();
				if (key.equals("stateId")) {
					finalQuery.setParameter(key, Integer.parseInt(value));
				} else if (key.equals("countryId")) {
					finalQuery.setParameter(key, Integer.parseInt(value));
				} else if (key.equals("mobileNuber")) {
					finalQuery.setParameter(key, Integer.parseInt(value));
				} else {
					finalQuery.setParameter(key, value);
				}
			}
			count = 0;
			return finalQuery.getResultList();
		}
	}

	public User findUserById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		return user;
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public boolean deleteUser(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		if (user != null) {
			session.delete(user);
			return true;
		} else {
			return false;
		}
	}
}
