package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.mapper.UserAnnotateMapper;

@Service
public class UserAnnotateServiceImp implements UserAnnotateService {

	@Autowired
	private UserAnnotateMapper mapper;
	
	@Override
	public List<User> getAll() {
		return mapper.list();
	}

	@Override
	public User getUser(Integer id) {
		return mapper.get(id);
	}

	@Override
	public void insert(User user) {
		mapper.add(user);
	}

	@Override
	public void update(User user) {
		mapper.update(user);
	}

	@Override
	public void delete(Integer id) {
		mapper.delete(id);
	}

}
