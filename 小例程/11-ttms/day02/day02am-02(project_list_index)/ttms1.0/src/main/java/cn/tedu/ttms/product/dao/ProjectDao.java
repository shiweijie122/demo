package cn.tedu.ttms.product.dao;

import java.util.List;

import cn.tedu.ttms.product.entity.Project;
/**数据持久层对象*/
public interface ProjectDao {
	
	/**获得表中所有记录*/
	List<Project> findObjects();
	/**将对象信息写入到表中*/
	int insertObject(Project entity);
	/**修改表中记录信息*/
	//int updateObject(Project entity);
	//.....
	
}
