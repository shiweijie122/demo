package cn.tedu.ttms.product.dao;

import java.util.List;

import cn.tedu.ttms.product.entity.Project;

/**���ݳ־ò����*/
public interface ProjectDao {
	/**��ñ������м�¼*/
	List<Project> findObjects();
	/**��������Ϣд�뵽����*/
	int insertObject(Project entity);
	/**�޸ı��м�¼��Ϣ*/
	//int updateObject(Project entity);
}
