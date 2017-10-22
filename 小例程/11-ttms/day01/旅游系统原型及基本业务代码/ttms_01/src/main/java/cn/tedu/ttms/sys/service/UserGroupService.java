package cn.tedu.ttms.sys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.sys.entity.UserGroup;


public interface UserGroupService {
	/**
	 * 基于主键查询
	 * 
	 * @param grpid
	 * @return
	 */
	UserGroup selectByPrimaryKey(String grpId, String grpType, String parentId);

	/**
	 * 取得组织机构
	 * 
	 * @param userGroup
	 * @param pageObj
	 * @return
	 */
	List<UserGroup> selectUserGroup(UserGroup userGroup, PageObject pageObj);

	List<UserGroup> selectCompanies();

	/**
	 * 获取组织机构的数据条数
	 * 
	 * @param userGroup
	 * @return
	 */
	int GetRecordCount(UserGroup userGroup);

	/**
	 * 添加组织机构
	 * 
	 * @param userGroup
	 * @return
	 */
	int addUserGroup(UserGroup userGroup);

	/**
	 * 删除组织机构
	 * 
	 * @param grpId
	 * @return
	 */
	int deleteUserGroup(String grpId);

	/**
	 * 保存组织机构
	 * 
	 * @param userGroup
	 * @return
	 */
	int saveUserGroup(UserGroup userGroup);

	/**
	 * 启用禁用
	 * 
	 * @param id
	 * @param valid
	 * @param updateUser
	 * @return
	 */
	int updateUserGroup(String id, String valid, String updateUser);

	List<UserGroup> selectGroup();

	String selectGroupNames(@Param(value = "grpIds") String grpIds);
}
