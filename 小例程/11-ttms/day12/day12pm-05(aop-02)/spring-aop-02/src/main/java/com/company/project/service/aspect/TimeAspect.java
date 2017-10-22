package com.company.project.service.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(1)
@Aspect
@Component
public class TimeAspect {
	@Before("bean(projectServiceImpl)")
	public void start(){
		System.out.println("start:"+System.nanoTime());
	}
	@After("bean(projectServiceImpl)")
	public void end(){
		System.out.println("end:"+System.nanoTime());
	}
	@AfterThrowing("bean(projectServiceImpl)")
	public void exp(){
		System.out.println("exception:"+System.nanoTime());
	}
    @AfterReturning("bean(projectServiceImpl)")
    public void retn(){
      System.out.println("return:"+System.nanoTime());
    }
}
