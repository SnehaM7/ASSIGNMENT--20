package com.aopdemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Helper {
	
	@Before("execution(public void Operations.operate())")
	public void sendNotification() {
		System.out.println("notification sent...");
	}
	
	@After("execution(public void operate())")
	public void sendEmail() {
		System.out.println("email sent...");
	}
	
	@Around("execution(public void operate())")
	public void logDetails(ProceedingJoinPoint jp) {
		System.out.println("Logging before operate");
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Logging after operate");
	}
	
}
