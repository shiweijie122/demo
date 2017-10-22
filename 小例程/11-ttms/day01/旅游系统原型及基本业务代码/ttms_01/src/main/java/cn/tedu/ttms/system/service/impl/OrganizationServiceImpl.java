package cn.tedu.ttms.system.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.base.exception.QueryException;
import cn.tedu.ttms.base.exception.SaveException;
import cn.tedu.ttms.base.exception.UpdateException;
import cn.tedu.ttms.system.entity.Organization;
import cn.tedu.ttms.system.mapper.OrganizationMapper;
import cn.tedu.ttms.system.service.OrganizationService;
@Service
public class OrganizationServiceImpl implements  OrganizationService{
	@Resource
	private OrganizationMapper orgMapper;
	
	public Map<String, Object> findObjects(Organization orgInfo, PageObject pageObj) {      
		List<Map<String,Object>> list=orgMapper.findObjects(orgInfo, pageObj);
		pageObj.setRowCount(orgMapper.getRowCounts(orgInfo));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageObj", pageObj);
		return map;
	}

	/**根据id修改组织状态*/
	
	public void validById(Integer id, Integer valid, String user) {
		
		 if(id==null)throw new NullPointerException("要修改的对象id不能为空");
		 List<Integer> childIds=orgMapper.findObjectsByParentID(id);
		 if(childIds.size()>0)throw new UpdateException("启动禁用状态失败");
		 int rows=orgMapper.validById(id, valid, user);
		 if(rows!=1)throw new UpdateException("修改失败");
	}
	/**保存状态信息*/
	
	public void saveObject(Organization orgInfo) {
		System.err.println("saveObject.orgInfo="+orgInfo);
		int id=orgMapper.insertObject(orgInfo);
		if(id==-1)throw new SaveException("数据保存失败");
	}
	
	public Map<String, Object> findById(String id) {
		if(id==null)throw new QueryException("项目id不能为空");
    	return orgMapper.findById(id);
	}
	
	public void updateObject(Organization orgInfo) {	
		System.out.println("oService.updateObject.info="+orgInfo);
		int id=orgMapper.updateObject(orgInfo);
		if(id==-1)throw new UpdateException("数据保存失败");
	}
}
