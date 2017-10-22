package cn.tedu.ttms.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.sys.entity.UserGroup;
import cn.tedu.ttms.sys.mapper.UserGroupMapper;
import cn.tedu.ttms.sys.service.UserGroupService;

@Service("userGroupService")
@Transactional
public class UserGroupServiceImpl implements UserGroupService {
	
	@Resource
	private UserGroupMapper userGroupMapper;

	/**
	 * 基于主键查询
	 * 
	 * @param grpid
	 * @return
	 */
	public UserGroup selectByPrimaryKey(String grpId, String grpType, String parentId) {
		return userGroupMapper.selectByPrimaryKey(grpId, grpType, parentId);
	}

	/**
	 * 取得组织机构
	 * 
	 * @param userGroup
	 * @param pageObj
	 * @return
	 */
	public List<UserGroup> selectUserGroup(UserGroup userGroup, PageObject pageObj) {
		return userGroupMapper.selectUserGroup(userGroup, pageObj);
	}

	public List<UserGroup> selectCompanies() {
		return userGroupMapper.selectCompanies();
	}

	/**
	 * 获取组织机构的数据条数
	 * 
	 * @param userGroup
	 * @return
	 */
	public int GetRecordCount(UserGroup userGroup) {
		return userGroupMapper.GetRecordCount(userGroup);
	}

	/**
	 * 添加组织机构
	 * 
	 * @param userGroup
	 * @return
	 */
	public int addUserGroup(UserGroup userGroup) {
		return userGroupMapper.addUserGroup(userGroup);
	}

	/**
	 * 删除组织机构
	 * 
	 * @param grpId
	 * @return
	 */
	public int deleteUserGroup(String grpId) {
		return userGroupMapper.deleteUserGroup(grpId);
	}

	/**
	 * 保存组织机构
	 * 
	 * @param userGroup
	 * @return
	 */
	public int saveUserGroup(UserGroup userGroup) {
		return userGroupMapper.saveUserGroup(userGroup);
	}

	/**
	 * 启用禁用
	 */
	public int updateUserGroup(String id, String valid, String updateUser) {
		return userGroupMapper.updateUserGroup(id, valid, updateUser);
	}

	public List<UserGroup> selectGroup() {
		return userGroupMapper.selectGroup();
	}

	public String selectGroupNames(String grpIds) {
		return userGroupMapper.selectGroupNames(grpIds);
	}
}
