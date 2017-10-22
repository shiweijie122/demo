package cn.tedu.ttms.project.service;

import java.util.Map;

import cn.tedu.ttms.project.entity.Project;
import cn.tedu.ttms.util.PageObject;

public interface ProjectService {
	Map<String,Object> findObjects(Project entity,PageObject pageObject);
	int saveObject(Project entity);	
	int updateObject(Project entity);
	Map<String,Object> findObjectById(Integer id);
    void validById(String ids,Integer valid);
}
