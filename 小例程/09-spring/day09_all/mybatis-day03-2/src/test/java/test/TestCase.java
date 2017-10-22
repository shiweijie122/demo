package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmployeeDAO;
import entity.Employee;

public class TestCase {
	private EmployeeDAO dao;
	@Before
	public void init(){
		String config = 
				"spring-mybatis.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		dao = ac.getBean("empDAO",
						EmployeeDAO.class);
	}
	
	@Test
	public void test1(){
		List<Employee> employees = 
				dao.findAll();
		System.out.println(employees);
	}
	
	@Test
	public void test2(){
		Employee e = new Employee();
		e.setName("Rose");
		e.setSalary(2000);
		e.setAge(22);
		dao.save(e);
		//这儿不用关心如何提交事务和关闭
		//SqlSession。这些操作Spring已经
		//帮我们做了。
	}
}




