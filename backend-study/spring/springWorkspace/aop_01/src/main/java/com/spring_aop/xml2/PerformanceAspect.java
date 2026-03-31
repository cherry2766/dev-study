package com.spring_aop.xml2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class PerformanceAspect {
	
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable { 
		Signature s = joinPoint.getSignature();
		String methodName = s.getName(); 
		
		System.out.println("------------------------------------------");
		System.out.println("[Log] Before: " +  methodName + "() : 실행 시작");
		System.out.println("------------------------------------------");
		
		long startTime = System.nanoTime();
		
		Object result = null;
		
		try {
			result = joinPoint.proceed(); 
		}catch(Exception e) {
			System.out.println("[LOG] Exception: " + methodName);
		}
		
		long endTime = System.nanoTime();
		
		System.out.println("------------------------------------------");
		System.out.println("[Log] After: " +  methodName + "() : 실행 종료");
		System.out.println("[Log] : " + methodName + "() 실행시간 : " + (endTime - startTime)+ "ns");
		System.out.println("------------------------------------------");
		
		return result;
	}

}
