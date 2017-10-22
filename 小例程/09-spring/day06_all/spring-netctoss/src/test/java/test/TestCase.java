package test;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.netctoss.dao.AdminDAO;
import cn.tedu.netctoss.entity.Admin;
import cn.tedu.netctoss.service.LoginService;


public class TestCase {
	
	private ApplicationContext ac;
	
	@Before
	//@Before修饰的方法会在其它测试方法运行
	//之前先执行。
	public void init(){
		String config = "spring-mvc.xml";
		ac = new ClassPathXmlApplicationContext(
					config);
	}
	
	@Test
	//测试  读取db.properties文件
	public void test1(){
		Properties db = 
				ac.getBean("db",
						Properties.class);
		System.out.println(db);
		
	}
	
	@Test
	//测试 连接池
	public void test2() throws SQLException{
		/*
		 * DataSource是一个接口，
		 * BasicDataSource是一个实现了该接口的
		 * 类。
		 */
		DataSource ds = 
			ac.getBean("ds",
					DataSource.class);
		System.out.println(
				ds.getConnection());
		
	}
	
	@Test
	//测试 持久层
	public void test3(){
		AdminDAO dao = 
				ac.getBean("adminDAO",
						AdminDAO.class);
		Admin admin = 
				dao.findByCode("caocao");
		System.out.println(admin);
		
	}
	
	@Test
	//测试 业务层
	public void test4(){
		LoginService ls = 
				ac.getBean("loginService",
						LoginService.class);
		Admin admin = 
				ls.checkLogin("caocao",
						"1234");
		System.out.println(admin);
	}
}








