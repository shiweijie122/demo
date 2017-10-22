package cn.tedu.ttms.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.user.entity.MenuRole;
import cn.tedu.ttms.user.entity.Role;



public interface RoleMapper {
	/**
	 * 查询角色
	 * 
	 * @param role
	 * @return
	 */
	List<Role> selectRole(@Param(value = "role") Role role, @Param(value = "pageObj") PageObject pageObj);

	/**
	 * 取得数据条数
	 * 
	 * @param role
	 * @return
	 */
	int getRecordCount(@Param(value = "role") Role role);

	/**
	 * 新增角色
	 * 
	 * @param role
	 * @return
	 */
	int addRole(@Param(value = "role") Role role);

	/**
	 * 更新角色
	 * 
	 * @param role
	 * @return
	 */
	int updateRole(@Param(value = "role") Role role);

	/**
	 * 删除角色
	 * 
	 * @param roleId
	 * @return
	 */
	int delRole(@Param(value = "roleId") String roleId);

	/**
	 * 保存菜单角色
	 * 
	 * @param menuRole
	 * @return
	 */
	int addMenuRole(@Param(value = "menuRole") MenuRole menuRole);

	/**
	 * 查询菜单角色
	 * 
	 * @param menuRole
	 * @return
	 */
	List<MenuRole> selectMenuRole(@Param(value = "menuRole") MenuRole menuRole);

	/**
	 * 删除菜单角色
	 * 
	 * @param roleId
	 * @return
	 */
	int delMenuRole(@Param(value = "roleId") String roleId);

	/**
	 *
	 * @param functionId
	 * @return
	 */
	String selectFunctionRights(String functionId);
}
