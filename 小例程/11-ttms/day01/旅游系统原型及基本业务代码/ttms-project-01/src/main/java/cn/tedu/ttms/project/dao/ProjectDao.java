package cn.tedu.ttms.project.dao;


import java.util.List;
import java.util.Map;

import cn.tedu.ttms.common.dao.BaseDao;
import cn.tedu.ttms.project.entity.Project;

public interface ProjectDao extends BaseDao<Project>{
	
	List<Map<String,Object>> findOptions();
}
