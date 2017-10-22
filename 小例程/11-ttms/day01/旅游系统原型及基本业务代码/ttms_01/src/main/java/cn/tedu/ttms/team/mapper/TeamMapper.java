package cn.tedu.ttms.team.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.team.entity.Team;

public interface TeamMapper {
	
	/**
	 * 查询全部的 团号信息， 包含3个列 numId number numberName 
	 */
	List<Map<String, Object>> findAllProductNumbers();

	/**
	 * 根据团号查询产品所属的项目编号
	 * @param numId
	 * @return
	 */
	String findProductPrjId(Integer numId);

	/**
	 * 根据团号查询产品所属的项目名称
	 * @param object
	 * @return
	 */
	String findPrjNameByNumId(Integer numId);

	/**
	 * 根据项目名称查询项目下所属的所有团号ID
	 * @param prjName
	 * @return
	 */
	List<Integer> findNumIdsByPrjName(String prjName);


	/**
	 * 获取团号列表，用于展示所有团号信息
	 * @param prjIdList 
	 * @param team 
	 * @param pageObj 
	 */
	List<Map<String, Object>> teamList(@Param("team")Team team, @Param("prjIdList")List<Integer> prjIdList, @Param("pageObj")PageObject pageObj);

	/**
	 * 统计查询的数据的总数
	 * @param team
	 * @param prjIdList
	 * @return
	 */
	int getRowCounts(@Param("team")Team team, @Param("prjIdList")List<Integer> prjIdList);

	/**
	 * 切换团号启用禁用状态
	 * @param team
	 */
	int changeState(@Param("team")Team team);

	/**
	 * 保存团信息
	 * @param team
	 */
	int saveTeam(@Param("team")Team team);

	/**
	 * 获取负责任下拉列表
	 * @param prjId
	 */
	List<Map<String, Object>> managerList(@Param("prjId")Integer prjId);

	/**
	 * 根据id查询团信息，用于修改
	 * @param teamId
	 */
	Map<String, Object> findTeamInfoById(@Param("teamId")Integer teamId);

	/**
	 * 更新团信息
	 * @param team
	 */
	int updateTeam(@Param("team")Team team);

}
