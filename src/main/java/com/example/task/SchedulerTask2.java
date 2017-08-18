package com.example.task;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask2 {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Scheduled(fixedRate = 5000)
	private void dateTask() {
		LOG.info("SchedulerTask2 : " + new Date().toString());
	}
}
