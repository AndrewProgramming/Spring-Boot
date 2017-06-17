package com.example.test;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.User;
import com.example.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAnnotateMapperTest {
	@Autowired
	private UserService service;
	
	@Test  //在需要运行的方法上添加 @Test 注解即可运行
	public void getAll() throws Exception {
		System.out.println(service.getAll());
	}
	
	//@Test
	public void add() throws Exception {
		User user = new User();
		user.setName("lingdu");
		user.setAccount("lingdu");
		service.insert(user);
	}
	
	//@Test
	public void update() throws Exception {
		User user = new User();
		
		//更新id=76的用户
		user.setId(79);
		//更新后的值
		user.setName("admin_lingdu");
		user.setAccount("admin_lingdu");
		service.update(user);
	}
	
	//@Test
	public void delete() throws Exception {
		service.delete(79);
	}
	
	//@Test
	public void getUser() throws Exception {
		
		System.out.println(service.getUser(79));
	}
	
	
}
