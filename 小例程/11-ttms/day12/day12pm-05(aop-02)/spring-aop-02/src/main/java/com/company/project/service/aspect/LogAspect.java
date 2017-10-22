package com.company.project.service.aspect;
/**借助此类封装日志操作*/
public class LogAspect {
	public void before(){
	   System.out.println("method.start");
	}
	public void after(){
	   System.out.println("method.after");
	}
}

