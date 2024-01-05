package com.cheonho.aop04;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {

	//@Around("execution(* com.cheonho.aop04.MyMath.*(..))")			//pointcut - 부가기능이 적용될 메서드의 패턴 
	public Object methodCallLog(ProceedingJoinPoint pjp) throws Throwable {
		
		long start = System.currentTimeMillis();
		System.out.println("");
		System.out.println("<<[start] " + pjp.getSignature().getName() + Arrays.toString(pjp.getArgs()));
		
		Object result = pjp.proceed();			// target의 메서드(핵심기능)를 호출
		
		System.out.println((System.currentTimeMillis() - start) + "ms");
		System.out.println("핵심 기능 결과 : " + result);
		System.out.println("<<[end]");
		System.out.println("");
		
		return result;
		
	}
	
	//@Before("execution(public * com.cheonho.aop04..*(..))")
	public void before(JoinPoint joinPoint) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@Before [ " + signatureString + " ]  메서드 실행 전처리 수행");
		for (Object arg : joinPoint.getArgs()) {
			System.out.println("@Before [ " +signatureString+ " ] 아규먼트 " + arg);
		}
		System.out.println("");
	}
	
	//@After("execution(* *..*.*add(..))")
	public void afterFinal(JoinPoint joinPoint) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@After [ " + signatureString + " ]  메서드 실행 완료 후 실행");	
		System.out.println("");
	}
	
	//@AfterReturning(pointcut = "execution(public * com.cheonho.aop04.*.*(..))", returning = "ret")
	public void afterReturning(JoinPoint joinPoint, Object ret) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@AfterReturning [ " + signatureString + " ]  메서드 실행 후처리 실행");
		System.out.println("@AfterReturning [ " + signatureString + " ]  리턴 값 = " + ret);
		System.out.println("");
	}
	
	@AfterThrowing(pointcut = "execution(* *..aop04.*.*(..))", throwing = "ex" )
	public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@afterThrowing [ " + signatureString + " ]  메서드 실행 중 예외 발생");
		System.out.println("@afterThrowing [ " + signatureString + " ]  예외 = " + ex.getMessage());
		System.out.println("");
	}
}














