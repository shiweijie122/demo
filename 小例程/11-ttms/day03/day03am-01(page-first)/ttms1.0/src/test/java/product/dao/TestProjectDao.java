package product.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.product.dao.ProjectDao;
import cn.tedu.ttms.product.entity.Project;

public class TestProjectDao {
	ClassPathXmlApplicationContext ctx;
	ProjectDao projectDao;
	@Before
	public void init(){
		 ctx= new ClassPathXmlApplicationContext(
				"spring-pool.xml",
				"spring-mybatis.xml");
		 projectDao=(ProjectDao)
			ctx.getBean("projectDao",
			ProjectDao.class);
	}
	
    @Test
	public void testFindObjects(){
    	//假设现在要取第2页的数据,每页显示2条(PageSize)
    	int pageCurrent=2;//当前页
    	int pageSize=2;//每页最多显示的记录数
    	int startIndex=(pageCurrent-1)*pageSize;
	    List<Project> list=
	    projectDao.findObjects(startIndex,
	    		pageSize);
		System.out.println(list);
		//测试list集合是否不等于空
		Assert.assertNotEquals(null, list);
	}
    @Test
    public void getRowCount(){
    	 int rowCount=
    	 projectDao.getRowCount();
    	 System.out.println(
    	 "rowCount="+rowCount);
    }
    
    
    
    @Test
    public void testInsertObject()throws Exception{
    	Project entity=new Project();
    	entity.setName("北京马拉松");
    	entity.setCode("tt-20170802-CN-BJ-002");
    	String begin="2017/08/12";
    	String end="2017/08/19";
    	SimpleDateFormat sdf=
        new SimpleDateFormat("yyyy/MM/dd");
    	entity.setBeginDate(sdf.parse(begin));
    	entity.setEndDate(sdf.parse(end));
    	entity.setValid(1);
    	entity.setNote("北京马拉松.....");
    	entity.setCreatedUser("admin");
    	entity.setModifiedUser("admin");
    	int rows=
    	projectDao.insertObject(entity);
    	System.out.println("rows="+rows);
    	//判定rows是否等于1
    	Assert.assertEquals(1, rows);
    }
    @After
    public void destory(){
    	ctx.close();
    	projectDao=null;
    }
}


