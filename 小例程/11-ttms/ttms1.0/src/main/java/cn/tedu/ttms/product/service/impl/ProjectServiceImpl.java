package cn.tedu.ttms.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ttms.product.dao.ProjectDao;
import cn.tedu.ttms.product.entity.Project;
import cn.tedu.ttms.product.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	/**使用@Resource注解为属性注入值时,先按名字查找,还是先按类型查找?====只能set注入,先按名字查找*/
	@Resource
	private ProjectDao projectDao;
	
	/**查询,获取项目信息*/
	public List<Project> findObjects() {
		List<Project> list = projectDao.findObjects();
		return list;
	}

}
