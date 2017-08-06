package com.example.aop;

import java.util.Arrays;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



import com.example.annotate.LogAop;

@Component
@Aspect
public class LogAspect {

	private static final Logger LOG = LoggerFactory.getLogger(LogAspect.class);

	@Before("@annotation(log)")
	public void beforeTest(JoinPoint joinPoint, LogAop log) throws Throwable {
		LOG.info("进入：" + log.name());
		LOG.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		LOG.info("参数 : " + Arrays.toString(joinPoint.getArgs()));
	}

	@After("@annotation(log)")
	public void afterTest(JoinPoint point, LogAop log) {
		LOG.info("退出：" + log.name());
	}
}
