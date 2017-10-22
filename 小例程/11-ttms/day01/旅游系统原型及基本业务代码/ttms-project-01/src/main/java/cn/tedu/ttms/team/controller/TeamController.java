package cn.tedu.ttms.team.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.team.entity.Team;
import cn.tedu.ttms.team.service.TeamService;
import cn.tedu.ttms.util.JsonResult;
import cn.tedu.ttms.util.PageObject;

@RequestMapping("/team")
@Controller
public class TeamController {
	
	@Resource
	private TeamService teamService;
	
	@RequestMapping("editUI")
	public String editUI() {
		return "team/team_edit";
	}
	@RequestMapping("/listUI")
	public String listUI() {
		return "team/team_list";
	}
	@RequestMapping("/findObjects")
	@ResponseBody
	public JsonResult doFindObjects(Team entity,PageObject pageObject) {
		Map<String,Object> map=teamService.findObjects(entity, pageObject);
		return new JsonResult(map);
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public JsonResult doSaveObject(Team entity) {
		teamService.saveObject(entity);
		return new JsonResult();
	}
	@RequestMapping("/update")
	@ResponseBody
	public JsonResult doUpdateObject(Team entity) {
		teamService.updateObject(entity);
		return new JsonResult();
	}
	
	@RequestMapping("/findById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
	    Map<String,Object> map=teamService.findObjectById(id);
	    System.out.println("map="+map);
	    return new JsonResult(map);
		
	}
	
	@RequestMapping("/findProjectOptions")
	@ResponseBody
	public JsonResult doFindProjects(){
		List<Map<String,Object>> list=teamService.findProjectOptions();
		System.out.println("projects="+list);
		return new JsonResult(list);
	}
	
	@RequestMapping("/doValidById")
	@ResponseBody
	public JsonResult doValidById(String checkedIds,Integer valid){
		teamService.validById(checkedIds,valid);
		return new JsonResult();
	}
}
