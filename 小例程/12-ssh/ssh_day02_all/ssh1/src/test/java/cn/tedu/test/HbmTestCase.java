package cn.tedu.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.entity.User;

public class HbmTestCase {
	SessionFactory factory;
	Session session;

	@Before
	public void init(){
		Configuration cfg=new Configuration();
		//加载主配置文件
		cfg.configure("hibernate.cfg.xml");
		//创建工厂对象
		factory = cfg.buildSessionFactory();
		//创建Session对象
		session = factory.openSession();
	}
	
	@After
	public void destory(){
		//Session 使用以后务必关闭
		session.close();
		factory.close();
	}
	
	@Test
	public void testSave(){
		Transaction tx = 
				session.beginTransaction();
		User user = new User(
				1, "Tom", 5, "北京");
		session.save(user);
		tx.commit();
	}
	
}







