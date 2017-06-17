package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import com.example.domain.User;

/**
 * dao层
 * 对应User表
 * 使用纯注解方式
 * @author LingDu
 */

public interface UserAnnotateMapper {
	
	@Select("SELECT * FROM USER")
	@Results({
		@Result(property="id",column="id",javaType=Integer.class),
		@Result(property="name",column="name"),
		@Result(property="account",column="account")
	})
	public List<User> list();

	@Select("SELECT * FROM USER WHERE ID = #{id}")
	@Results({
		@Result(property="id",column="id",javaType=Integer.class),
		@Result(property="name",column="name"),
		@Result(property="account",column="account")
	})
	public User get(Integer id);

	@Insert("INSERT INTO USER(NAME,ACCOUNT) VALUES(#{name},#{account})")
	public void add(User user);

	@Update("UPDATE USER SET NAME=#{name},ACCOUNT=#{account} WHERE id=#{id}")
	public void update(User user);

	@Delete("DELETE FROM USER WHERE ID = #{id}")
	public void delete(Integer id);
}
