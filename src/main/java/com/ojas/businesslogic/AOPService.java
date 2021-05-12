package com.ojas.businesslogic;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPService {

	@Pointcut("execution(public void com.ojas.businesslogic.BusinessLogic.saveEmployee())")
	public void p1() {
	}

	@Before("p1()")
	public void tX() {
		System.out.println("Begin Tx");
	}

	@After("p1()")
	public void commit() {
		System.out.println("TX commited");
	}
//
//	@AfterThrowing(value = "p1()", throwing = "th")
//	public void comitTh(Throwable th) {
//		System.out.println("After throwing Demo " + th.getMessage());
//	}

	@Around("p1()")
	public void aroundDemo(ProceedingJoinPoint jp) {
		System.out.println("Before bussiness method");
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("After bussines method");
	}
}
