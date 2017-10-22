package cn.tedu.ttms.team.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.base.exception.QueryException;
import cn.tedu.ttms.base.exception.SaveException;
import cn.tedu.ttms.base.exception.UpdateException;
import cn.tedu.ttms.project.mapper.ProjectMapper;
import cn.tedu.ttms.team.entity.Team;
import cn.tedu.ttms.team.mapper.TeamMapper;
import cn.tedu.ttms.team.service.TeamService;

@Service("teamService")
@Transactional
public class TeamServiceImpl implements TeamService {
	
	@Resource
	private TeamMapper teamMapper;
	
	@Resource 
	private ProjectMapper projectMapper;

	
	public Map<String, Object> teamList(Team team,String prjName,PageObject pageObj) {
		pageObj.setStartIndex(pageObj.getStartIndex());
		List<Integer> prjIdList = new ArrayList<Integer>();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		if(prjName!=null&&!("".equals(prjName))){
			prjIdList = findPrjIdsByName(prjName);
			if(prjIdList.size()>0){
				list = teamMapper.teamList(team,prjIdList,pageObj);
				pageObj.setRowCount(teamMapper.getRowCounts(team,prjIdList));
			}else{
				list = null;
				pageObj.setRowCount(0);
			}
		}else{
			list = teamMapper.teamList(team,prjIdList,pageObj);
			pageObj.setRowCount(teamMapper.getRowCounts(team,prjIdList));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("teamList", list);
		map.put("pageObj", pageObj);
		return map;
	}


	/**
	 * 根据项目名称查询符合条件的项目id集合
	 * @param prjName
	 * @return
	 */
	private List<Integer> findPrjIdsByName(String prjName) {
		if(prjName==null || "".equals(prjName)){
			throw new NullPointerException("项目名称不能为空！");
		}
		return projectMapper.findPrjIdsByName(prjName);
	}

	/**
	 * 切换启用禁用状态
	 */
	
	public void changeState(Team team, String userName) {
		if(team==null){
			throw new NullPointerException("切换团号状态，团号对象不能为空！");
		}
		if(userName==null || "".equals(userName)){
			throw new NullPointerException("获取当前用户信息失败！");
		}
		team.setModifiedUser(userName);
		int i = teamMapper.changeState(team);
		if(i!=1){
			throw new UpdateException("切换团号启用禁用状态失败！");
		}
	}


	
	public void saveTeam(Team team, String userName) {
		if(team==null){
			throw new NullPointerException("保存团信息，团信息不能为空！");
		}
		if(userName==null || "".equals(userName)){
			throw new NullPointerException("获取当前用户信息失败！");
		}
		team.setCreatedUser(userName);
		team.setModifiedUser(userName);
		int i = teamMapper.saveTeam(team);
		if(i!=1){
			throw new SaveException("保存团信息失败！");
		}
	}


	
	public List<Map<String, Object>> projectList() {
		 return  projectMapper.projectList();
		
	}


	
	public List<Map<String, Object>> managerList(Integer prjId) {
		if(prjId==null){
			throw new NullPointerException("获取负责人下拉列表，项目id不能为空！");
		}
		List<Map<String, Object>> list = teamMapper.managerList(prjId);
		return list;
	}


	
	public Map<String, Object> findTeamInfoById(Integer teamId) {
		if(teamId==null){
			throw new NullPointerException("修改团信息，团id不能为空！");
		}
		Map<String, Object> map = teamMapper.findTeamInfoById(teamId);
		if(map==null){
			throw new QueryException("修改团信息，查询失败！");
		}
		return map;
	}


	
	public void updateTeam(Team team, String userName) {
		if(team==null){
			throw new NullPointerException("修改团信息，团信息不能为空！");
		}
		if(userName==null){
			throw new NullPointerException("获取当前用户信息失败！");
		}
		team.setModifiedUser(userName);
		int i = teamMapper.updateTeam(team);
		if(i!=1){
			throw new UpdateException("修改团信息失败!");
		}
	}
}
