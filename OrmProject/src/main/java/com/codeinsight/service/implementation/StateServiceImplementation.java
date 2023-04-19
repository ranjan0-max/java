package com.codeinsight.service.implementation;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeinsight.dao.StateDao;
import com.codeinsight.entity.Country;
import com.codeinsight.entity.State;
import com.codeinsight.service.StateService;

@Service
public class StateServiceImplementation implements StateService{

	@Autowired
	private StateDao stateDao;

	@Transactional
	public List<State> getAllState() {
		List<State> stateList = stateDao.getAllState();
		for(State state : stateList) {
			state.setCountry(null);
		}
		return stateList;
	}
	
	@Transactional
	public State findStateById(Integer Id) {
		State state = stateDao.findStateById(Id);
		Country country = (Country) Hibernate.unproxy(state.getCountry());
		state.setCountry(country);
		return state;
	}

	@Transactional
	public boolean deleteState(Integer id) {
		boolean deleteState = stateDao.deleteState(id);
		return deleteState;
	}

	@Transactional
	public void insertState(State state) {
		stateDao.insertState(state);
	}

	@Transactional
	public void updateState(State state) {
		stateDao.updateState(state);
	}
}
