package ssh2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.entity.Comment;
import cn.tedu.entity.Post;
import cn.tedu.entity.User;

public class TestCase {

	ClassPathXmlApplicationContext ctx;
	SessionFactory factory;
	Session session;
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext(
				"spring-pool.xml",
				"spring-hibernate.xml");
		factory = ctx.getBean(
			"sessionFactory", SessionFactory.class);
		session = factory.openSession();
	}
	
	@After
	public void destory(){
		session.close();
		factory.close();
		ctx.close();
	}
	
	@Test
	public void testGet(){
		Integer id=1;
		Post post=(Post)session.get(
			Post.class, id);
		System.out.println(post);
		
		User user = (User)session.get(
				User.class, 1);
		System.out.println(user);
		
		Comment comment = (Comment)session.get(
				Comment.class, 1);
		System.out.println(comment);
	}
	
	@Test
	public void testLazy(){
		Integer id=1;
		Post post=(Post)session.get(
			Post.class, id);
		System.out.println(post.getContent());
		System.out.println("1");
		//"懒惰加载"关联属性, 在第一次使用关联属性
		//时候才执行响应的SQL,查询数据.		
		System.out.println(post.getUser());
		session.close();
		//在Session关闭以后, 懒惰加载将出现故障!\
		//如果不是懒惰加载, 则不受影响!
		System.out.println("2");
		System.out.println(post.getComments());

	}
	
}



