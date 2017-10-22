package cn.tedu.ttms.team.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.base.controller.JsonBaseController;
import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.team.entity.Team;
import cn.tedu.ttms.team.service.TeamService;
import cn.tedu.ttms.base.entity.JsonResult;

/**
 * 团号控制器
 * @author Admin
 *
 */
@Controller
@RequestMapping("/team")
public class TeamController extends JsonBaseController {
	
	@Resource
	private TeamService teamService;
	
	/**
	 * 点击导航栏团号管理，跳转到团号管理页面
	 * @return
	 */
	@RequestMapping("/list.do")
	public String list(){
		return "ttms/team/teamManageList";
	}

	/**
	 * 获取团号列表，用于展示所有团号信息
	 * @return
	 */
	@RequestMapping("/teamList.do")
	@ResponseBody
	public JsonResult<Map<String, Object>> teamList(Team team,String prjName,PageObject pageObj){
		Map<String, Object> map = teamService.teamList(team,prjName,pageObj);
		return new JsonResult<Map<String,Object>>(map);
	}
	
	/**
	 * 切换启用禁用状态
	 */
	@RequestMapping("/changeState.do")
	@ResponseBody
	public JsonResult<Object> changeState(Team team,HttpSession session){
		String userName = getCurrentUser(session).getUserName();
		teamService.changeState(team,userName);
		return new JsonResult<Object>();
	}
	
	/**
	 * 保存团号
	 */
	@RequestMapping("/saveTeam.do")
	@ResponseBody
	public JsonResult<Object> saveTeam(Team team,HttpSession session){
		String userName = getCurrentUser(session).getUserName();
		teamService.saveTeam(team,userName);
		return new JsonResult<Object>();
	}
	
	/**
	 * 获取项目列表，用于展示项目下拉列表
	 */
	@RequestMapping("/projectList.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> projectList(){
		List<Map<String, Object>> list = teamService.projectList();
		return new JsonResult<List<Map<String, Object>>>(list);
	}
	
	/**
	 * 获取负责人列表，用于展示负责人下拉列表
	 */
	@RequestMapping("/managerList.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> managerList(Integer prjId){
		List<Map<String, Object>> list = teamService.managerList(prjId);
		return new JsonResult<List<Map<String, Object>>>(list);
	}
	
	/**
	 * 根据id查询团信息,用于修改
	 */
	@RequestMapping("/findTeamInfoById.do")
	@ResponseBody
	public JsonResult<Map<String, Object>> findTeamInfoById(Integer teamId){
		Map<String, Object> map = teamService.findTeamInfoById(teamId);
		return new JsonResult<Map<String, Object>>(map);
	}
	
	/**
	 * 更改团信息
	 */
	@RequestMapping("/updateTeam.do")
	@ResponseBody
	public JsonResult<Object> updateTeam(Team team,HttpSession session){
		System.err.println(team);
		String userName = getCurrentUser(session).getUserName();
		teamService.updateTeam(team,userName);
		return new JsonResult<Object>();
	}
}
