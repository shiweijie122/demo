package cn.tedu.ttms.user.entity;

import java.io.Serializable;

public class Menu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5867507810537916387L;
	/**
	 * 菜单编号
	 */
	private String menuId;
	/**
	 * 菜单名称
	 */
	private String menuName;
	/**
	 * 菜单链接
	 */
	private String linkUrl;
	
	/**
	 * 图标
	 */
	private String icon;
	
	/**
	 * 父菜单
	 */
	private String parentMenu;
	/**
	 * 菜单排序
	 */
	private String sortLevel;
	/**
	 * 菜单描述
	 */
	private String menuDesc;
	
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(String parentMenu) {
		this.parentMenu = parentMenu;
	}
	public String getSortLevel() {
		return sortLevel;
	}
	public void setSortLevel(String sortLevel) {
		this.sortLevel = sortLevel;
	}
	public String getMenuDesc() {
		return menuDesc;
	}
	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}
}
