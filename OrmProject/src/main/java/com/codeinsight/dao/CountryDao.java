package com.codeinsight.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codeinsight.entity.Country;

@Repository
public class CountryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertCountry(Country country) {
		sessionFactory.getCurrentSession().save(country);

	}

	public List<Country> getAllCountry() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Country", Country.class).list();
	}

	public Country findCountryById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Country.class, id);
	}

	public void updateCountry(Country country) {
		sessionFactory.getCurrentSession().update(country);
	}

	public boolean deleteCountry(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Country country = session.get(Country.class, id);
		if(country != null) {
			session.delete(country);	
			return true;
		} else {
			return false;
		}
	}
}
