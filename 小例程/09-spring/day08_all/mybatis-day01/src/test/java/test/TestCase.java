package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity.Emp;
import entity.Employee;

public class TestCase {
	private SqlSession session;

	@Before
	public void init() {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

		SqlSessionFactory ssf = ssfb.build(TestCase.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml"));

		// 获得SqlSession对象
		// (SqlSession是执行sql的一个容器)。
		session = ssf.openSession();
	}

	@Test
	public void test1() {
		Employee e = new Employee();
		e.setName("Giving King");
		e.setSalary(12000);
		e.setAge(22);

		session.insert("test.save", e);
		// 提交事务
		session.commit();
		// 关闭SqlSession
		session.close();
	}

	@Test
	public void test2() {
		List<Employee> employees = 
				session.selectList(
						"test.findAll");
		System.out.println(employees);
		session.close();
	}
	
	@Test
	public void test3(){
		Employee e = session.selectOne(
				"test.findById", 2);
		System.out.println(e);
		session.close();
	}
	
	@Test
	public void test4(){
		Employee e = session.selectOne(
				"test.findById", 2);
		e.setSalary(e.getSalary() * 2);
		
		session.update("test.update", e);
		//添加、修改、删除操作都需要提交事务
		session.commit();
		session.close();
	}
	
	@Test
	public void test5(){
		session.delete("test.delete", 2);
		session.commit();
		session.close();
	}
	
	@Test
	public void test6(){
		Map map = 
				session.selectOne(
					"test.findById2", 21);
		//oracle数据库会将字段名统一变成大写
		//形式。
		System.out.println(map.get("NAME"));
	}
	
	@Test
	public void test7(){
		Emp emp = 
				session.selectOne(
					"test.findById3",21);
		System.out.println(emp);
	}
	
}











