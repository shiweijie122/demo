package test.proxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.company.project.service.ProjectService;
public class AopTest01 {
	ClassPathXmlApplicationContext ctx;
	ProjectService projectService;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-aop.xml");
		//?这个Bean对象有没有自己new
		projectService=
		ctx.getBean("projectServiceImpl",ProjectService.class);
	    //?有没有自己构建一个代理类
	}
	@Test
	public void testSaveObject(){
		projectService.saveObject(null);
	}
	@Test
	public void testUpdateObject(){
		projectService.updateObject(null);
	}
	@After
	public void destory(){
		ctx.close();
	}
}

