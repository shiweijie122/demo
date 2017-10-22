package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation.Apple;
import annotation.ExampleBean;
import annotation.Leader;
import annotation.Manager;
import annotation.Restaurant;

public class TestCase2 {
	@Test
	//测试  组件扫描
	public void test1(){
		String config = "annotation.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		//缺省的id是首字母小写之后的类名
		Apple a1 = 
				ac.getBean("a1",Apple.class);
		System.out.println(a1);
	}
	
	@Test
	//测试  初始化方法和销毁方法
	public void test2(){
		String config = "annotation.xml";
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Apple a1 = 
				ac.getBean("a1",Apple.class);
		System.out.println(a1);
		ac.close();
	}
	
	@Test
	//测试  作用域
	public void test3(){
		String config = "annotation.xml";
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Apple a1 = 
				ac.getBean("a1",Apple.class);
		Apple a2 = 
				ac.getBean("a1",Apple.class);
		System.out.println(a1 == a2);
		ac.close();
	}
	
	@Test
	//测试 延迟加载
	public void test4(){
		String config = "annotation.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
	}
	
	@Test
	//测试 @Autowired和@Qualifier
	public void test5(){
		String config = "annotation.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Restaurant rest = 
				ac.getBean("rest",
						Restaurant.class);
		System.out.println(rest);
		
		Leader ld1 = 
				ac.getBean("ld1",Leader.class);
		System.out.println(ld1);
	}
	
	@Test
	public void test6(){
		String config = "annotation.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Manager mg = 
				ac.getBean("mg",Manager.class);
		System.out.println(mg);
	}
	
	@Test
	//测试  @Value   
	public void test7(){
		String config = "annotation.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		ExampleBean eb = 
				ac.getBean("eb",
						ExampleBean.class);
		System.out.println(eb);
	}
	
	
	
	
	
}


