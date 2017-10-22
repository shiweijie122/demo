package cn.tedu.ttms.team.service;

import java.util.List;
import java.util.Map;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.team.entity.Team;

public interface TeamService {

	/**
	 *  获取团号列表，用于展示所有团号信息
	 * @param prjName 
	 * @param team 
	 * @param pageObj 
	 * @param mgrName 
	 * @return 
	 */
	Map<String, Object> teamList(Team team, String prjName, PageObject pageObj);

	/**
	 * 切换启用禁用状态
	 * @param team
	 * @param user
	 */
	void changeState(Team team, String userName);

	/**
	 * 保存团号
	 * @param team
	 * @param userName
	 */
	void saveTeam(Team team, String userName);

	/**
	 * 获取项目列表，用于展示项目下拉列表
	 * @return 
	 */
	List<Map<String, Object>> projectList();

	/**
	 * 获取负责人列表，用于展示负责任下列表
	 * @param prjId
	 * @return 
	 */
	List<Map<String, Object>> managerList(Integer prjId);

	/**
	 * 根据id查询团信息,用于修改
	 * @param teamId
	 * @return 
	 */
	Map<String, Object> findTeamInfoById(Integer teamId);

	/**
	 * 更改团信息
	 * @param team
	 * @param userName
	 */
	void updateTeam(Team team, String userName);

}
