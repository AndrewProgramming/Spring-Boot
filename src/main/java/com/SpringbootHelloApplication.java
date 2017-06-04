package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.servlet.Servlet1;
/**
 * Spring Boot 教程一
 * Spring Boot 入门
 * @author LingDu
 */
@SpringBootApplication
@ServletComponentScan //使用注解的方式注册servlet需要在SpringbootHelloApplication.java中添加@ServletComponentScan注解
public class SpringbootHelloApplication {

	/*@Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new Servlet1(),"/servlet/*");// ServletName默认值为首字母小写，即servlet
    }*/
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootHelloApplication.class, args);
	}
}
