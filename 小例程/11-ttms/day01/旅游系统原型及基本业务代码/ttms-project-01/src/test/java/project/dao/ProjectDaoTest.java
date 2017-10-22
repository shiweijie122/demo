package project.dao;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.project.dao.ProjectDao;
import cn.tedu.ttms.project.entity.Project;
import cn.tedu.ttms.util.PageObject;
public class ProjectDaoTest {
	
	ClassPathXmlApplicationContext ctx;
	@Before 
	public void initCtx(){
		ctx = new ClassPathXmlApplicationContext("spring-mvc.xml","spring-pool.xml","spring-mybatis.xml");
	}
	@After
	public void closeCtx(){
		ctx.close();
	}
	@Test
	public void testInsert()throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		ProjectDao dao=(ProjectDao) ctx.getBean("projectDao",ProjectDao.class);
		Project p1=new Project();
		p1.setCode("TPCN-20170701-CHN-PEK-001");
		p1.setName("2017年澳大利亚乌鲁鲁马拉松");
		p1.setBeginDate(sdf.parse("2017-07-18"));
		p1.setEndDate(sdf.parse("2017-07-25"));
		p1.setValid(1);
		p1.setNote("专属红土马拉松，乌鲁鲁巨岩10km排酸跑，高碳晚餐，赛后安排乌鲁鲁日落，卡塔丘塔徒步，特色原野星光秀");
		dao.insertObject(p1);
		
		Project p2=new Project();
		p2.setCode("TP-20170710-USA-NY-001");
		p2.setName("2017美国纽约马拉松");
		p2.setBeginDate(sdf.parse("2017-08-01"));
		p2.setEndDate(sdf.parse("2017-08-08"));
		p2.setValid(1);
		p2.setNote("跑步纵览纽约城市魅力，热情的观众和专业的跑步组织");
		dao.insertObject(p2);
		
		
		Project p3=new Project();
		p3.setCode("TP-20170710-DEU-BER-001");
		p3.setName("2017德国柏林马拉松自由行");
		p3.setBeginDate(sdf.parse("2017-08-10"));
		p3.setEndDate(sdf.parse("2017-08-20"));
		p3.setValid(1);
		p3.setNote("落地参团，往返接送机服务,赛前晚餐+赛后特色餐，全程专业摄影摄像");
		dao.insertObject(p3);
		
		Project p4=new Project();
		p4.setCode("TP-20170710-FIN-HEL-001");
		p4.setName("2017 徒步北欧探梦布道石");
		p4.setBeginDate(sdf.parse("2017-09-10"));
		p4.setEndDate(sdf.parse("2017-09-20"));
		p4.setValid(1);
		p4.setNote("勇攀布道石，全程四星酒店，浮士德，诗丽雅双游轮，畅游三峡湾，安徒生博物馆，伊埃斯科城堡");
		dao.insertObject(p4);
	}
	@Test
	public void testUpdate()throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		ProjectDao dao=(ProjectDao) ctx.getBean("projectDao",ProjectDao.class);
		Project p=new Project();
		p.setId(1);
		p.setCode("TP-20170701-AUS-ULU-001");
		p.setName("2017年澳大利亚乌鲁鲁马拉松");
		p.setCreatedTime(sdf.parse("2017-07-18"));
		p.setEndDate(sdf.parse("2017-07-25"));
		p.setValid(1);
		p.setNote("专属红土马拉松，乌鲁鲁巨岩10km排酸跑，高碳晚餐，赛后安排乌鲁鲁日落，卡塔丘塔徒步，特色原野星光秀");
		dao.updateObject(p);
	}
	@Test
	public void testFindObjects()throws Exception{
		ProjectDao dao=(ProjectDao) ctx.getBean("projectDao");
		Project entity=new Project();
		PageObject pageObject=new PageObject();
		List<Map<String,Object>> list=dao.findObjects(entity,pageObject);
		System.out.println(list);
		Assert.assertNotEquals(null, list);
	}
	@Test
	public void testValidById()throws Exception{
		ProjectDao dao=(ProjectDao) ctx.getBean("projectDao");
		int rows=dao.validById(new String[] {"1"}, 0);
		System.out.println("valid.rows="+rows);
		Assert.assertNotEquals(-1, rows);
	}
	
	
}