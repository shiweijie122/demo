package cn.tedu.ttms.project.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.base.controller.BaseController;
import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.project.entity.Project;
import cn.tedu.ttms.project.service.ProjectService;
import cn.tedu.ttms.base.entity.JsonResult;

/**
 * 项目信息
 * @author Admin
 */
@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController {
	@Resource
	private ProjectService projectService;
	/**
	 * 查询 项目信息
	 * @param model
	 * @param projectInfo
	 * @param pageObj
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findProjects.do")
	@ResponseBody
	public JsonResult<Map<String,Object>> projectList(Model model, Project projectInfo, PageObject pageObj) throws Exception {
         return  new JsonResult<Map<String,Object>>(projectService.findProjects(projectInfo, pageObj));
	}
	/**
	 * 获取部门列表， 用于展现部门选择列表
	 */
	@RequestMapping("/findGroups.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> groupList(){
		return new JsonResult<List<Map<String,Object>>>(projectService.findOrganizations());
	}
	/**点击页面菜单中的项目管理*/
	@RequestMapping("/manageUI.do")
	public String  manageUI(){
		return "ttms/project/project_list";
	}
	
	/**
	 * 启用 禁用
	 * @param id
	 * @param valid
	 * @param updateUser
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("/validById.do")
    @ResponseBody
	public JsonResult<Object> validById(Integer prjId,Integer valid,HttpSession session){
    	String user = getCurrentUser(session).getUserName();
    	projectService.validProjectById(prjId, valid, user);
        return new JsonResult<Object>();
	}
     /**
	 * 新增 项目信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addUI.do")
	public String projectAddUI(Model model) throws Exception {
		return "ttms/project/project_add";
	}
	
	
	/**
	 * 新增 项目信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editUI.do")
	public String projectEditUI(Model model) throws Exception {
		return "ttms/project/project_edit";
	}
	
	
	/**
	 * 编辑保存 项目信息
	 * @param projectInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save.do")
	@ResponseBody
	public JsonResult<Object> projectSave( Project projectInfo,HttpSession session) throws Exception {
		String user = getCurrentUser(session).getUserName();
		projectInfo.setCreatedUser(user);
		projectService.saveProject(projectInfo);
		return  new JsonResult<Object>();
	}
	
	
	
	/***
	 * 根据id查找项目信息，然后将项目信息封装到jsonResult对象中
	 * @param prjId
	 * @return
	 */
	@RequestMapping("/findById.do")
	@ResponseBody
	public JsonResult<Map<String,Object>> findById(String prjId){
		Map<String,Object> map=projectService.findProjectById(prjId);
		return new JsonResult<Map<String,Object>>(map);
	}
	
	
	
	/**
	 * 修改项目信息
	 * @param projectInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateById.do")
	@ResponseBody
	public JsonResult<Object> projectUpdate( Project projectInfo,HttpSession session) throws Exception {
		String user = getCurrentUser(session).getUserName();
		projectInfo.setModifiedUser(user);
		projectService.updateProject(projectInfo);
		return  new JsonResult<Object>();
	}
}
