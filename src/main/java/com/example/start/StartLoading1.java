package com.example.start;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Order 注解的执行优先级是按value值从小到大顺序。
 * @author LingDu
 */
@Component
@Order(value=1) //优先级 
public class StartLoading1 implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("优先级：1 ********* StartLoading1：服务启动的时候运行，正在加载数据。。。。。");
	}
}
