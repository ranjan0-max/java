package com.codeinsight.service;

import java.util.List;

import com.codeinsight.entity.State;

	public interface StateService {

	public List<State> getAllState();
	
	public State findStateById(Integer id);
	
	public boolean deleteState(Integer id);
	
	public void insertState(State state);
	
	public void updateState(State state);
}
