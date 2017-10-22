package com.company.project.service.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Component 通过此注解告诉spring容器,这个对象\
 * 要由spring来管理.
 * @Aspect 通过此注解声明这是一个切面
 * */
@Order(2)
@Aspect
@Component
public class TrasactionAspect {
	/**通过Pointcut声明切入点*/
	@Pointcut("execution(* com.company.project.service.*Service.*(..))")
	public void method(){}
	/**通过@Before定义这是一个前置通知
	 * 前置通知对应核心业务执行之前要实现
	 * 的一个扩展业务操作
	 * */
	@Before("method()")
	public void beginTx(JoinPoint point){
		//point.getArgs()
	    System.out.println("开启事务:"+point.getSignature());
	}
	/**通过@After定义这是一个最终通知
	 * 后置通知对应核心业务执行之后要
	 * 实现的一个扩展业务操作.
	 * */
	@After("execution(* com.company.project.service.*Service.*(..))")
	public void commitTx(){
	    System.out.println("提交事务");
	}
}
