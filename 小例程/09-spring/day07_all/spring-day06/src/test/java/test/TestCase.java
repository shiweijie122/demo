package test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmployeeDAO;
import entity.Employee;

public class TestCase {
	private EmployeeDAO dao;
	private ApplicationContext ac;
	
	@Before
	public void init(){
		String config = "spring-jdbc.xml";
		ac = 
		new ClassPathXmlApplicationContext(
				config);
		dao = ac.getBean("empDAO",
				EmployeeDAO.class);
	}
	
	@Test
	//测试 连接池
	public void test() throws SQLException{
		DataSource ds = 
				ac.getBean("ds",DataSource.class);
		System.out.println(
				ds.getConnection());
	}
	
	@Test
	public void test1(){
		Employee e = new Employee();
		e.setName("Sally Tong");
		e.setSalary(20000);
		e.setAge(33);
		dao.save(e);
	}
	
	@Test
	public void test2(){
		List<Employee> employees = 
				dao.findAll();
		System.out.println(employees);
	}
	
	@Test
	public void test3(){
		Employee e = 
				dao.findById(1);
		System.out.println(e);
	}
	
	@Test
	public void test4(){
		Employee e = 
				dao.findById(1);
		e.setName("Sally Wang");
		e.setSalary(e.getSalary() * 2);
		e.setAge(e.getAge() + 10);
		dao.update(e);
	}
	
	@Test
	public void test5(){
		dao.delete(1);
	}
	
	
	
	
}
