package test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import entity.Employee;

public class TestCase {
	@Test
	public void test1(){
		SqlSessionFactoryBuilder ssfb = 
		new SqlSessionFactoryBuilder();
		
		SqlSessionFactory ssf = 
			ssfb.build(
				TestCase.class.getClassLoader()
				.getResourceAsStream(
						"SqlMapConfig.xml"));
		
		
		//获得SqlSession对象
		//(SqlSession是执行sql的一个容器)。
		SqlSession session = 
				ssf.openSession();
		
		Employee e = new Employee();
		e.setName("Giving King");
		e.setSalary(12000);
		e.setAge(22);
		
		session.insert("test.save", e);
		//提交事务
		session.commit();
		//关闭SqlSession
		session.close();
		
		
		
		
	}
}




