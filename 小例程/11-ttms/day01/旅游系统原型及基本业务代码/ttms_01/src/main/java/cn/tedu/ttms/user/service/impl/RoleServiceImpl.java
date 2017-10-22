package cn.tedu.ttms.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.user.entity.MenuRole;
import cn.tedu.ttms.user.entity.Role;
import cn.tedu.ttms.user.mapper.RoleMapper;
import cn.tedu.ttms.user.service.RoleService;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleMapper roleMapper;

	public List<Role> selectRole(Role role, PageObject pageObj) throws Exception {
		return roleMapper.selectRole(role, pageObj);
	}

	public int getRecordCount(Role role) throws Exception {
		return roleMapper.getRecordCount(role);
	}

	public int addRole(Role role) throws Exception {
		return roleMapper.addRole(role);
	}

	public int updateRole(Role role) throws Exception {
		return roleMapper.updateRole(role);
	}

	public int delRole(String roleId) throws Exception {
		delMenuRole(roleId);
		return roleMapper.delRole(roleId);
	}

	public int addMenuRole(List<MenuRole> menuRoleList, String roleId) throws Exception {
		int ret = 0;
		delMenuRole(roleId);
		for (MenuRole menuRole : menuRoleList) {
			ret = roleMapper.addMenuRole(menuRole);
		}

		return ret;
	}

	public List<MenuRole> selectMenuRole(MenuRole menuRole) throws Exception {
		return roleMapper.selectMenuRole(menuRole);
	}

	public int delMenuRole(String roleId) throws Exception {
		return roleMapper.delMenuRole(roleId);
	}

	public String selectFunctionRights(String functionId) throws Exception {
		return roleMapper.selectFunctionRights(functionId);
	}
}
