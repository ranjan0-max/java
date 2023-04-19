package com.codeinsight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeinsight.entity.State;
import com.codeinsight.service.StateService;

@RestController
public class StateController {

	@Autowired
	private StateService stateService;

	@GetMapping("/state")
	public List<State> getAllState() {
		List<State> stateList = stateService.getAllState();
		return stateList;
	}

	@GetMapping("/state/{id}")
	public State findStateById(@PathVariable Integer id) {
		State state = stateService.findStateById(id);
		return state;
	}
	
	@DeleteMapping("/state/{id}")
	public void deleteState(@PathVariable Integer id) {
		boolean deleteState = stateService.deleteState(id);
		if (deleteState) {
			System.out.println("user deleted");
		} else {
			System.out.println("user Not present");
		}
	}
	
	@PostMapping("/state")
	public void insertState(@RequestBody State state) {
		stateService.insertState(state);
	}
	
	@PutMapping("/state")
	public void updateUser(@RequestBody State state) {
		stateService.updateState(state);
	}
}
