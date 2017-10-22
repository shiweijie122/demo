package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.EmployeeDAO;
import entity.Emp;
import entity.Employee;

public class TestCase {
	private SqlSession session;
	private EmployeeDAO dao;
	
	@Before
	public void init() {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

		SqlSessionFactory ssf = ssfb.build(TestCase.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml"));

		session = ssf.openSession();
		
		/*
		 * getMapper方法会返回符合
		 * Mapper映射器（即EmployeeDAO接口）
		 * 要求的对象。
		 */
		dao =
			session.getMapper(
						EmployeeDAO.class);
	}
	
	@Test
	public void test1(){
		Employee e = new Employee();
		e.setName("Eric");
		e.setSalary(20000);
		e.setAge(22);
		
		dao.save(e);
		//如果是删除、添加、修改，仍然
		//需要提交事务
		session.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		List<Employee> employees = 
				dao.findAll();
		System.out.println(employees);
		session.close();
	}
	
	@Test
	public void test3(){
		Employee e = 
				dao.findById(21);
		System.out.println(e);
		session.close();
	}
	
	
	@Test
	public void test4(){
		Employee e = 
				dao.findById(21);
		e.setSalary(e.getSalary() + 10);
		dao.update(e);
		session.commit();
		session.close();
	}
	
	
	@Test
	public void test5(){
		dao.delete(21);
		session.commit();
		session.close();
	}
	
	@Test
	public void test6(){
		Map map = 
				dao.findById2(22);
		System.out.println(map);
		session.close();
	}
	
	
	@Test
	public void test7(){
		Emp emp = 
				dao.findById3(22);
		System.out.println(emp);
		session.close();
	}
	
	
	
	
	
}








