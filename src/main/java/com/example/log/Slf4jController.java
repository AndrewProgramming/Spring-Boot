package com.example.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class Slf4jController {
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	@RequestMapping("/log")
	public String log(){
		logger.info("当前类：com.example.log.Slf4jController");
		
		return "日志测试。";
	}
}
