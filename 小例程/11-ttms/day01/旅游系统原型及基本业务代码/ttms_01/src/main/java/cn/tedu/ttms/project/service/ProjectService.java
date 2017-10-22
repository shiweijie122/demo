package cn.tedu.ttms.project.service;
import java.util.List;
import java.util.Map;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.project.entity.Project;

public interface ProjectService {
	Map<String,Object> findProjects(Project projectInfo, PageObject pageObj);
	void deleteProjectById(String prjId,String user);
    void validProjectById(Integer prjId,Integer valid,String user);
    void saveProject(Project projectInfo);
    Map<String,Object>findProjectById(String prjId);
    void updateProject(Project projectInfo);
	public List<Map<String, Object>> findOrganizations() ;
}
