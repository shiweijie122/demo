package product.controller;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.common.controller.IndexController;

public class TestController {
	@Test
	public void testIndex(){
		//1.���ApplicationContext����
		ApplicationContext  ctx=
		new ClassPathXmlApplicationContext("spring-mvc.xml");
        IndexController c=(IndexController)
        ctx.getBean("indexController");
        System.out.println("c="+c);
	}
}
