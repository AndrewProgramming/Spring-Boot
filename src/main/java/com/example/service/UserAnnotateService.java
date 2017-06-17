package com.example.service;

import java.util.List;

import com.example.domain.User;

public interface UserAnnotateService {
	public List<User> getAll();
	public User getUser(Integer id);
	public void insert(User user);
	public void update(User user);
	public void delete(Integer id);
}
