package cn.tedu.ttms.project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.base.exception.DeleteException;
import cn.tedu.ttms.base.exception.QueryException;
import cn.tedu.ttms.base.exception.SaveException;
import cn.tedu.ttms.base.exception.UpdateException;
import cn.tedu.ttms.common.Constants;
import cn.tedu.ttms.project.entity.Project;
import cn.tedu.ttms.project.mapper.ProjectMapper;
import cn.tedu.ttms.project.service.ProjectService;
import cn.tedu.ttms.system.mapper.OrganizationMapper;

@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {
	@Resource
	private ProjectMapper projectMapper;
	@Resource
	private OrganizationMapper orgMapper;

	/**分页查询所有项目信息*/
	public Map<String,Object> findProjects(Project projectInfo, PageObject pageObj) {
		List<Map<String,Object>> list=projectMapper.findObjects(projectInfo, pageObj);
		if(list==null)throw new QueryException("没有匹配的数据！");
		pageObj.setRowCount(projectMapper.getRowCounts(projectInfo));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageObj", pageObj);
		
		System.out.println("findProjects.map="+map);
		return map;
	}
	/**获得项目的部门信息*/
	public List<Map<String, Object>> findOrganizations() {
		List<Map<String,Object>> list= orgMapper.findObjectsByCode(Constants.Organization.PRODUCT);
		System.err.println("findOrganizations.orgList="+list);
		return list;
	}
	/**根据id删除项目信息*/
	public void deleteProjectById(String prjIds,String user){
		  if(prjIds==null)throw new NullPointerException("项目id不能为空");
		  String prjIdArray[]=prjIds.split(",");
		  for(String prjId:prjIdArray){
		   System.out.println("prjId="+prjId);  
		   int rows=projectMapper.deleteById(prjId);
		   if(rows!=1){
			  throw new DeleteException("数据"+prjId+"删除失败");
		   }
		  }
	}
	/**修改项目有效信息*/
	
	public void validProjectById(Integer prjId, Integer valid,String user) {
		if (prjId == null)
			throw new NullPointerException("项目id不能为空");
		if (valid == null)
			throw new NullPointerException("项目状态信息不能为空");
		if (user == null)
			throw new NullPointerException("请确保用户已登录");
		int rows = projectMapper.validById(prjId, valid, user);
		if (rows != 1)
			throw new UpdateException("修改失败");
	}
    /**保存项目信息 */
	
    public void saveProject(Project projectInfo){
		int rows=projectMapper.insertObject(projectInfo);
		if(rows!=1){
			throw new SaveException("保存失败");
		}
    }
    
    public Map<String, Object> findProjectById(String prjId) {
    	if(prjId==null){
    		throw new QueryException("项目id不能为空");
    	}
    	return projectMapper.findById(prjId);
    }
    
    /*修改項目信息*/
    
    public void updateProject(Project projectInfo) {
        int rows=projectMapper.updateObject(projectInfo);
        if(rows!=1)throw new UpdateException("更新失敗");
    }
}
