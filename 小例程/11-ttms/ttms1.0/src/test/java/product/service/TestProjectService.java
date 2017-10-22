package product.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.product.entity.Project;
import cn.tedu.ttms.product.service.ProjectService;

public class TestProjectService {

	private ClassPathXmlApplicationContext ctx;
	private ProjectService projectService;
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("spring-pool.xml","spring-mybatis.xml","spring-mvc.xml");
		projectService = ctx.getBean("projectServiceImpl",ProjectService.class);
	}
	
	@Test
	public void testFindObject(){
		
		List<Project> list = projectService.findObjects();
		System.out.println(list);
		//验证list集合是否不等于null
		Assert.assertNotEquals(null, list);
	}
}
