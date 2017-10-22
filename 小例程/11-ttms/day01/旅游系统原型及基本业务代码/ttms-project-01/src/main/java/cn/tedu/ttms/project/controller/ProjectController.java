package cn.tedu.ttms.project.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.project.entity.Project;
import cn.tedu.ttms.project.service.ProjectService;
import cn.tedu.ttms.util.JsonResult;
import cn.tedu.ttms.util.PageObject;

@Controller
@RequestMapping("/project")
public class ProjectController{
	@Resource
	private ProjectService projectService;
	@RequestMapping("/editUI")
	public String editUI() {
		return "project/project_edit";
	}
	@RequestMapping("/listUI")
	public String listUI() {
		return "project/project_list";
	}
	@RequestMapping("/findObjects")
	@ResponseBody
	public JsonResult doFindObjects(Project entity,PageObject pageObject){
		Map<String,Object> map=projectService.findObjects(entity, pageObject);
		return new JsonResult(map);
	}
	@RequestMapping("/save")
	@ResponseBody
	public JsonResult doSaveObject(Project entity) {
		projectService.saveObject(entity);
		return new JsonResult();
	}
	@RequestMapping("/update")
	@ResponseBody
	public JsonResult doUpdateObject(Project entity) {
		projectService.updateObject(entity);
		return new JsonResult();
	}
	@RequestMapping("/findById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
		Map<String,Object> map=projectService.findObjectById(id);
		return new JsonResult(map);
	}
	@RequestMapping("/doValidById")
	@ResponseBody
	public JsonResult doValidById(String checkedIds,Integer valid){
		projectService.validById(checkedIds,valid);
		return new JsonResult();
	}
	
}
