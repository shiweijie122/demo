package cn.tedu.ttms.team.service;

import java.util.List;
import java.util.Map;

import cn.tedu.ttms.team.entity.Team;
import cn.tedu.ttms.util.PageObject;

public interface TeamService {
	Map<String,Object> findObjects(Team entity,PageObject pageObject);
	void saveObject(Team entity);	
	void updateObject(Team entity);
	Map<String,Object> findObjectById(Integer id);
    void validById(String ids,Integer valid);
    
    List<Map<String, Object>>  findProjectOptions();
}
