package cn.tedu.ttms.user.entity;

import java.io.Serializable;

/**
 * 用户-角色
 * @author Admin
 *
 */
public class UserRole implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1357203468918271319L;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 角色编号
	 */
	private String roleId;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
