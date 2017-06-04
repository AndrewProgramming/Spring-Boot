package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
  
@RestController  
//@RequestMapping(value="/index")  
@RequestMapping("/hello")  
public class HelloController {  
      
    //@RequestMapping(value="/hello")  
	@RequestMapping("")
    public String helloworld(){  
        return "hello world!";  
    }  
}  