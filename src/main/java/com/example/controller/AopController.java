package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.annotate.LogAop;

@RestController
@RequestMapping("/aop")
public class AopController {

	@LogAop(name="/aop/aop.action") //添加了注解之后才会被拦截
	@RequestMapping("/aop")
    public String aop(){  
        return "hello world!";  
    }
	
	@RequestMapping("/noAop")    //这个方法是不会被拦截的
	public String noAop(){
		return "hello world!";  
	}
}
