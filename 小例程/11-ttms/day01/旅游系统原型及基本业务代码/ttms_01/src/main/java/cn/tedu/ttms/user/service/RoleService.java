package cn.tedu.ttms.user.service;

import java.util.List;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.user.entity.MenuRole;
import cn.tedu.ttms.user.entity.Role;



public interface RoleService {
	/**
	 * 查询角色
	 * 
	 * @param role
	 * @return
	 */
	List<Role> selectRole(Role role, PageObject pageObj) throws Exception;

	/**
	 * 取得数据条数
	 * 
	 * @param role
	 * @return
	 */
	int getRecordCount(Role role) throws Exception;

	/**
	 * 新增角色
	 * 
	 * @param role
	 * @return
	 */
	int addRole(Role role) throws Exception;

	/**
	 * 更新角色
	 * 
	 * @param role
	 * @return
	 */
	int updateRole(Role role) throws Exception;

	/**
	 * 删除角色
	 * 
	 * @param roleId
	 * @return
	 */
	int delRole(String roleId) throws Exception;

	/**
	 * 保存菜单角色
	 * 
	 * @param menuRole
	 * @return
	 */
	int addMenuRole(List<MenuRole> menuRoleList, String roleId) throws Exception;

	/**
	 * 查询菜单角色
	 * 
	 * @param menuRole
	 * @return
	 */
	List<MenuRole> selectMenuRole(MenuRole menuRole) throws Exception;

	/**
	 * 删除菜单角色
	 * 
	 * @param roleId
	 * @return
	 */
	int delMenuRole(String roleId) throws Exception;

	/**
	 *
	 * @param functionId
	 * @return
	 * @throws Exception
	 */
	String selectFunctionRights(String functionId) throws Exception;
}
