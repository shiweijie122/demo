package product.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.product.dao.ProjectDao;
import cn.tedu.ttms.product.entity.Project;

public class TestProjectDao {

	ProjectDao projectDao;
	ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("spring-pool.xml","spring-mybatis.xml");
		projectDao= (ProjectDao)ctx.getBean("projectDao",ProjectDao.class);
		
	}
	
	@Test
	public void tsetFindObjects(){
		
		List<Project> list = projectDao.findObjects();
		System.out.println(list);
		//����list�����Ƿ񲻵��ڿ�
		Assert.assertNotEquals(null, list);
		ctx.close();
	}
	
	@Test
	public void testinsertObject() throws ParseException{
		Project project = new Project();
		project.setName("����������");
		project.setCode("tt-20.170802-CN-BJ-002");
		String begin = "2017-08-02";
		String endDate = "2017-08-10";
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		project.setBeginDate(fmt.parse(begin));
		project.setEndDate(fmt.parse(endDate));
		project.setValid(0);
		project.setNote("����,ȥʺ��");
		project.setCreatedUser("ʷά��");
		project.setModifiedUser("ʷά��");
		int rows = projectDao.insertObject(project);
		System.out.println("rows="+rows);
		Assert.assertEquals(1, rows);
	}
	
}
