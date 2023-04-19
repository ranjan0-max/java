package com.codeinsight.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codeinsight.entity.State;

@Repository
public class StateDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertState(State state) {
		sessionFactory.getCurrentSession().save(state);

	}

	public List<State> getAllState() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM State", State.class).list();
	}

	public State findStateById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(State.class, id);
	}

	public void updateState(State state) {
		sessionFactory.getCurrentSession().update(state);
	}

	public boolean deleteState(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		State state = session.get(State.class, id);
		if(state != null) {
			session.delete(state);	
			return true;
		} else {
			return false;
		}
	}
}
