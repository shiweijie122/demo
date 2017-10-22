package cn.tedu.ttms.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ttms.system.dao.OrganizationDao;
import cn.tedu.ttms.system.entity.Organization;
import cn.tedu.ttms.system.service.OrganizationService;
import cn.tedu.ttms.util.PageObject;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Resource
	private OrganizationDao organizationDao;
	@Override
	public Map<String, Object> findObjects(Organization entity, PageObject pageObject) {
		List<Map<String,Object>> list=organizationDao.findObjects(entity, pageObject);
		pageObject.setRowCount(organizationDao.getRowCounts(entity));	
		Map<String,Object> map=new HashMap<>();
		map.put("list", list);
		map.put("pageObject",pageObject);	
		return map;
	}
	
	@Override
	public void saveObject(Organization entity) {
		entity.setParentIds(entity.makeSelfAsParentIds());
		int result=organizationDao.insertObject(entity);
		if(result!=1)throw new RuntimeException("insert error");
	}
	
	@Override
	public void updateObject(Organization entity) {
		int result=organizationDao.updateObject(entity);
		if(result!=1)throw new RuntimeException("update error");	
	}
	@Override
	public Map<String, Object> findObjectById(Integer id) {
		if(id==null)throw new NullPointerException("id 不能 为空");
		return organizationDao.findObjectById(id);
	}
	@Override
	public void validById(String ids, Integer valid) {
		if(ids==null)throw new RuntimeException("必须选中一个id");
		String[] array=ids.split("/");
		int result=organizationDao.validById(array, valid);
		if(result<0){
			throw new RuntimeException("更新失败");
		}
	}

}
