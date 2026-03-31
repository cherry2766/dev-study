package com.spring_aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

//공통기능 메소드 포함 (proxy에 해당)
public class PerformanceAspect {
	//각 핵심기능의 시작시간, 종료시간을 로그 기록
	//핵심기능 수행 전/후 시간 출력
	//공통기능 수행 메소드 : trace()	
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable { //JoinPoint : 핵심 기능 메소드 호출 시점
		Signature s = joinPoint.getSignature();
		String methodName = s.getName(); //핵심기능 메소드 이름
		
		System.out.println("------------------------------------------");
		System.out.println("[Log] Before: " +  methodName + "() : 실행 시작");
		System.out.println("------------------------------------------");
		
		long startTime = System.nanoTime();
		
		Object result = null;
		
		try {
			result = joinPoint.proceed(); // 핵심기능 수행
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
