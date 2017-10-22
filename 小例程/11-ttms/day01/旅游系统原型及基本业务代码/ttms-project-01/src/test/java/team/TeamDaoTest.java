package team;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.team.dao.TeamDao;
import cn.tedu.ttms.team.entity.Team;
import cn.tedu.ttms.util.PageObject;

public class TeamDaoTest {

	ClassPathXmlApplicationContext ctx;
	private TeamDao teamDao;
	@Before 
	public void initCtx(){
		ctx = new ClassPathXmlApplicationContext("spring-mvc.xml","spring-pool.xml","spring-mybatis.xml");
		teamDao=ctx.getBean("teamDao",TeamDao.class);
	}
	@After
	public void closeCtx(){
		ctx.close();
	}
	@Test
	public void testInsert()throws Exception{
		
		Team t1=new Team();
		t1.setName("2017美国纽约马拉松3日团");
		t1.setProjectId(5);
		t1.setValid(1);
		t1.setNote("2017美国纽约马拉松3日团Happy");
	    teamDao.insertObject(t1);
	    
		Team t2=new Team();
		t2.setName("2017美国纽约马拉松5日团");
		t2.setProjectId(5);
		t2.setValid(1);
		t2.setNote("2017美国纽约马拉松3日团Happy");
	    teamDao.insertObject(t2);
		
	}
	@Test
	public void testFindObjects()throws Exception{
		Team entity=new Team();
		PageObject pageObject=new PageObject();
		
		List<Map<String,Object>> list=teamDao.findObjects(entity, pageObject);
		System.out.println(list);
		
	}
}

