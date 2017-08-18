package com.example.task;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class SchedulerTask1 {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Scheduled(cron="*/5 * * * * ?")
	public void dateTask(){
		LOG.info("SchedulerTask1 : " + new Date().toString());
	}
}
