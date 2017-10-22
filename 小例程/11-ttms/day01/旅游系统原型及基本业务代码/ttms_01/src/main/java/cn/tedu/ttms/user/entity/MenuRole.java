package cn.tedu.ttms.user.entity;

import java.io.Serializable;

/**
 * 菜单-角色
 * @author Admin
 *
 */
public class MenuRole implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1033642133936350393L;
	/**
	 * 菜单编号
	 */
	private String menuId;
	/**
	 * 权限编号
	 */
	private String roleId;
	
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
