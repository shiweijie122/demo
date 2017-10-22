package cn.tedu.web;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@Component
public class DemoInterceptor 
	implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(
			ActionInvocation invocation) 
			throws Exception {
		System.out.println("开始");
		long t1 = System.currentTimeMillis();
		String val = invocation.invoke();
		long t2 = System.currentTimeMillis();
		System.out.println("结束:"+val+":"+(t2-t1));
		return val;
	}

}
