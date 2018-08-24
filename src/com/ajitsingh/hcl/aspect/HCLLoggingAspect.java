package com.ajitsingh.hcl.aspect;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HCLLoggingAspect {

	// Setup for logger
	private Logger LOGGER = LoggerFactory.getLogger(HCLLoggingAspect.class);
//	long BEFORE_EXECUTION=0;
//	long AFTER_EXECUTION=0;

	// Setup for pointcut declaration

	@Pointcut("execution (* com.ajitsingh.hcl.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution (* com.ajitsingh.hcl.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("execution (* com.ajitsingh.hcl.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void forApplicationFlow() {
	}

	// Setup for @Before advice

	/*
	 * JoinPoint will give us metadata for the method calls
	 */
	@Before("forApplicationFlow()")
	public void before(JoinPoint theJoinPoint) {

		// display methods we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		LOGGER.info("<<======> @Before: calling method " + theMethod);

		// display method arguments to the method
		Object[] args = theJoinPoint.getArgs();

		for (Object tempArg : args)
			LOGGER.info("<<======>> arguments: " + tempArg);

	}

	// Setup for @AfterReturning Advice
	@AfterReturning(
			pointcut="forApplicationFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		//display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		LOGGER.info("<<======> @AfterReturning: from method " + theMethod);
		
		//display data returned
		LOGGER.info("<<======> result : " + theResult);
		
	}
	

}
