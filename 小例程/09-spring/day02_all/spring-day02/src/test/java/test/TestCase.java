package test;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import auto.Restaurant;
import ioc.Manager;
import value.Student;

public class TestCase {
	@Test
	//测试  构造器注入
	public void test1(){
		String config = "ioc.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Manager mg1 = 
				ac.getBean("mg1",Manager.class);
		System.out.println(mg1);
	}
	
	@Test
	//测试 自动装配
	public void test2(){
		String config = "auto.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Restaurant rest = 
				ac.getBean("rest",
						Restaurant.class);
		System.out.println(rest);
	}
	
	@Test
	// 测试 注入基本类型的值和集合类型的值
	public void test3(){
		String config = "value.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Student stu1 = 
				ac.getBean("stu1",
						Student.class);
		System.out.println(stu1);
	}
	
	@Test
	// 测试 引用的方式注入集合类型的值
	public void test4(){
		String config = "value.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Student stu1 = 
				ac.getBean("stu2",
						Student.class);
		System.out.println(stu1);
	}
	
	@Test
	//测试  读取属性文件的内容
	public void test5(){
		String config = "value.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Properties props = 
			ac.getBean("config",
					Properties.class);
		System.out.println(props);
		
	}
	
}




