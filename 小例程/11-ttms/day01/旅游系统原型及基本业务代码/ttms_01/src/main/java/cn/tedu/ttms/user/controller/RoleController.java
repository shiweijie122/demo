package cn.tedu.ttms.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.base.controller.BaseController;
import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.sys.utils.DataOptUtil;
import cn.tedu.ttms.user.entity.MenuRole;
import cn.tedu.ttms.user.entity.Role;
import cn.tedu.ttms.user.service.RoleService;



/**
 * 角色管理
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
	@Resource
	private RoleService roleService;
	
	/**
	 * 取得角色
	 * @param model
	 * @param role
	 * @param pageObj
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public String selectRole(Model model,Role role, PageObject pageObj) throws Exception {
		List<Role> roleList = this.roleService.selectRole(role,pageObj);
		if(pageObj == null) {
			pageObj = new PageObject();
		}
		pageObj.setStartIndex(pageObj.getStartIndex());
		pageObj.setRowCount(roleService.getRecordCount(role));
		model.addAttribute("roleName", role.getRoleName());
		model.addAttribute("roleList", roleList);
		model.addAttribute("pageObject",pageObj);
		return "role/roleList";
	}
	
	/**
	 * 角色编辑初期化
	 * @param model
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("edit")
	public String editRole(Model model, Role role) throws Exception {
		if(DataOptUtil.isNotNull(role.getRoleId())) {
			List<Role> roleList = this.roleService.selectRole(role,null);
			role = roleList.size()>0?roleList.get(0):role;
			model.addAttribute("role", role);
		}
		return "role/editRole";
	}
	
	/**
	 * 保存角色
	 * @param role
	 * @return
	 */
	@RequestMapping("save")
	public String saveRole(Role role) throws Exception{
		if(DataOptUtil.isNull(role.getRoleId())) { //新增
			this.roleService.addRole(role);
		} else { //编辑
			this.roleService.updateRole(role);
		}
		
		return "redirect:roleList.do";
	}
	
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("delete")
	public String delRole(String roleId) throws Exception{
		this.roleService.delRole(roleId);
		return "redirect:roleList.do";
	}
	
	/**
	 * 设置权限
	 * @param model
	 * @param roleId
	 * @return
	 */
	@RequestMapping("setPermissions")
	public String setPermissions(Model model, String roleId) throws Exception{
		model.addAttribute("roleId", roleId);
		return "role/setPermissions";
	}
	
	/**
	 * 取得菜单角色
	 * @param menuRole
	 * @return
	 */
	@RequestMapping("getMenuRole")
	@ResponseBody
	public List<MenuRole> getMenuRole(MenuRole menuRole) throws Exception {
		return roleService.selectMenuRole(menuRole);
	}
	
	/**
	 * 保存权限设置
	 * @param roleId
	 * @param menuIds
	 * @return
	 */
	@RequestMapping("savePermissions")
	public String savePermissions(String roleId, String menuIds) throws Exception {

		String[] ids = menuIds.split(",");
		List<MenuRole> menuRoleList = new ArrayList<MenuRole>();
		for(String id:ids){
			if(DataOptUtil.isNotNull(id)){
				MenuRole menuRole = new MenuRole();
				menuRole.setRoleId(roleId);
				menuRole.setMenuId(id);
				menuRoleList.add(menuRole);
			}
		}
		roleService.addMenuRole(menuRoleList,roleId);
		return "redirect:roleList.do";
	}

	/**
	 * 取得系统权限
	 * @param functionId
	 * @return
	 */
	@RequestMapping("selectFunctionRights")
	@ResponseBody
	public String selectFunctionRights(String functionId) throws Exception {
		return roleService.selectFunctionRights(functionId);
	}
}
