package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.MessageBean;
import basic.ScopeBean;
import ioc.A;

public class TestCase {
	@Test
	//测试  初始化方法和销毁方法
	public void test1(){
		//启动spring容器
		String config = "basic.xml";
		/*
		 * 因为ApplicatioContext没有提供
		 * close方法，所以需要使用
		 * AbstractApplicationContext。
		 */
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		//通过容器获得对象
		MessageBean mb1 = 
			ac.getBean("mb1",MessageBean.class);
		mb1.sendMsg();
		//关闭容器
		ac.close();
	}
	
	
	@Test
	//测试  作用域
	public void test2(){
		//启动spring容器
		String config = "basic.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
			config);
		ScopeBean sb1 = 
				ac.getBean("sb1",
						ScopeBean.class);
		ScopeBean sb2 = 
				ac.getBean("sb1",
						ScopeBean.class);
		System.out.println(sb1 == sb2);
		
	}
	
	@Test
	//测试 延迟加载
	public void test3(){
		//启动spring容器
		String config = "basic.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		
	}
	
	@Test
	//测试 set方法注入
	public void test4(){
		//启动spring容器
		String config = "ioc.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		A a1 = 
				ac.getBean("a1",A.class);
		a1.service();
		
	}
	
	
	
	
}






