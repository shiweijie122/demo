package cn.tedu.ttms.sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.sys.entity.UserGroup;


public interface UserGroupMapper {
	/**
	 * 取得组织机构
	 * 
	 * @param userGroup
	 * @return
	 */
	List<UserGroup> selectUserGroup(@Param(value = "userGroup") UserGroup userGroup,
			@Param(value = "pageObj") PageObject pageObj);

	List<UserGroup> selectCompanies();

	/**
	 * 基于主键查询
	 * 
	 * @param grpid
	 * @return
	 */
	UserGroup selectByPrimaryKey(@Param(value = "grpId") String grpId, @Param(value = "grpType") String grpType,
			@Param(value = "parentId") String parentId);

	/**
	 * 获取组织机构的数据条数
	 * 
	 * @param userGroup
	 * @return
	 */
	int GetRecordCount(@Param(value = "userGroup") UserGroup userGroup);

	/**
	 * 添加组织机构
	 * 
	 * @param userGroup
	 * @return
	 */
	int addUserGroup(@Param(value = "userGroup") UserGroup userGroup);

	/**
	 * 删除组织机构
	 * 
	 * @param grpId
	 * @return
	 */
	int deleteUserGroup(@Param(value = "grpId") String grpId);

	/**
	 * 保存组织机构
	 * 
	 * @param userGroup
	 * @return
	 */
	int saveUserGroup(@Param(value = "userGroup") UserGroup userGroup);

	/**
	 * 启用禁用
	 * 
	 * @param id
	 * @param valid
	 * @param updateUser
	 * @return
	 */
	int updateUserGroup(@Param(value = "id") String id, @Param(value = "valid") String valid,
			@Param(value = "updateUser") String updateUser);

	List<UserGroup> selectGroup();

	String selectGroupNames(@Param(value = "grpIds") String grpIds);
	
	/**
	 * 查询全部2级部门，用于选择部门
	 * @return
	 */
	List<Map<String, Object>> findGroupsLevel2();
	
}
