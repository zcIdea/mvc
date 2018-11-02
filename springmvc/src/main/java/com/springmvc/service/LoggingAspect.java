package com.springmvc.service;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 * 
 */
@Component
@Aspect
public class LoggingAspect {

	
	/**
	 * 指定切入点
	 */
	@Pointcut("execution(* com.springmvc.dao.*.*(..))")
	public void saveOrUpdateUser() {
	}
	
    /**
     * 前置通知：目标方法执行之前执行以下方法体的内容 
     * @param jp
     */
//    @Before("execution(* com.springmvc.dao.UserDao.get(..))")
    @Before("execution(* com.springmvc.dao.*.*(..))")
    public void beforeMethod(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        System.out.println("【前置通知】the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
    }

    /**
     * 返回通知：目标方法正常执行完毕时执行以下代码
     * @param jp
     * @param result
     */
//    @AfterReturning(value="execution(* com.springmvc.dao.UserDao.get(..))",returning="result")
    @AfterReturning(value = "saveOrUpdateUser()", argNames = "rtv", returning = "rtv")
    public void afterReturningMethod(JoinPoint jp, Object result){
        String methodName = jp.getSignature().getName();
        System.out.println("【返回通知】the method 【" + methodName + "】 ends with 【" + result + "】");
    }

    /**
     * 后置通知：目标方法执行之后执行以下方法体的内容，不管是否发生异常。
     * @param jp
     */
    /*@After("execution(* com.qcc.beans.aop.*.*(..))")
    public void afterMethod(JoinPoint jp){
        System.out.println("【后置通知】this is a afterMethod advice...");
    }*/

    /**
     * 异常通知：目标方法发生异常的时候执行以下代码
     */
    /*@AfterThrowing(value="execution(* com.qcc.beans.aop.*.*(..))",throwing="e")
    public void afterThorwingMethod(JoinPoint jp, NullPointerException e){
        String methodName = jp.getSignature().getName();
        System.out.println("【异常通知】the method 【" + methodName + "】 occurs exception: " + e);
    }*/

//  /**
//   * 环绕通知：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
//   * @return 
//   */
//  @Around(value="execution(* com.qcc.beans.aop.*.*(..))")
//  public Object aroundMethod(ProceedingJoinPoint jp){
//      String methodName = jp.getSignature().getName();
//      Object result = null;
//      try {
//          System.out.println("【环绕通知中的--->前置通知】：the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
//          //执行目标方法
//          result = jp.proceed();
//          System.out.println("【环绕通知中的--->返回通知】：the method 【" + methodName + "】 ends with " + result);
//      } catch (Throwable e) {
//          System.out.println("【环绕通知中的--->异常通知】：the method 【" + methodName + "】 occurs exception " + e);
//      }
//      
//      System.out.println("【环绕通知中的--->后置通知】：-----------------end.----------------------");
//      return result;
//  }

}