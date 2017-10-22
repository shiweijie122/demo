package cn.tedu.ttms.user.entity;

import java.io.Serializable;

/**
 * 角色
 * @author Admin
 *
 */
public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1876580037666646125L;
	/**
	 * 权限编号
	 */
	private String roleId;
	/**
	 * 权限名称
	 */
	private String roleName;
	/**
	 * 权限描述
	 */
	private String roleInfo;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(String roleInfo) {
		this.roleInfo = roleInfo;
	}
}
