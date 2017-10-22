package project.dao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;

public class DataSourceTest {
	@Test
	public void testPool() {
		ApplicationContext ctx=
		new ClassPathXmlApplicationContext("spring-pool.xml");    
		DruidDataSource dataSource=(DruidDataSource)ctx.getBean("dataSource");
		System.out.println(dataSource);
	}

}
