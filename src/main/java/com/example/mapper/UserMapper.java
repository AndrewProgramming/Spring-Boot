package com.example.mapper;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.example.domain.User;

/**
 * dao层
 * 对应User表
 * @author LingDu
 */

public interface UserMapper {
	public List<User> list();

	public User get(Integer id);

	public void add(User user);

	public void update(User user);

	public void delete(Integer id);
}
