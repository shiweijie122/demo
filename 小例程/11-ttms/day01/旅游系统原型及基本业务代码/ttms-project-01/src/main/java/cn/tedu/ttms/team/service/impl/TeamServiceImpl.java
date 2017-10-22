package cn.tedu.ttms.team.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ttms.project.dao.ProjectDao;
import cn.tedu.ttms.team.dao.TeamDao;
import cn.tedu.ttms.team.entity.Team;
import cn.tedu.ttms.team.service.TeamService;
import cn.tedu.ttms.util.PageObject;

@Service
public class TeamServiceImpl implements TeamService {
	@Resource
	private TeamDao teamDao;
	@Resource
	private ProjectDao projectDao;
	
	@Override
	public Map<String, Object> findObjects(Team entity, PageObject pageObject) {
		List<Map<String,Object>> list=teamDao.findObjects(entity, pageObject);
		pageObject.setRowCount(teamDao.getRowCounts(entity));
		Map<String,Object> map=new HashMap<>();
		map.put("list",list);
		map.put("pageObject", pageObject);	
		return map;
	}

	@Override
	public void saveObject(Team entity) {
		int result=teamDao.insertObject(entity);
		if(result!=1)throw new RuntimeException("insert error");
	}

	@Override
	public void updateObject(Team entity) {
		int result=teamDao.updateObject(entity);
	    if(result!=1)throw new RuntimeException("update ok");	
	}

	@Override
	public Map<String, Object> findObjectById(Integer id) {
	    if(id==null)throw new NullPointerException("id 不能为空");
		return teamDao.findObjectById(id);
	}

	@Override
	public void validById(String ids, Integer valid) {
		if(ids==null)throw new RuntimeException("必须选中一项");
		if(valid==null)throw new RuntimeException("设置的选项值不能为空");
		String[] idArray=ids.split(",");
		int result=teamDao.validById(idArray, valid);
		if(result<0){
			throw new RuntimeException("更新失败");
		}
	}
	@Override
	public List<Map<String, Object>> findProjectOptions() {
		return projectDao.findOptions();
	}
}
