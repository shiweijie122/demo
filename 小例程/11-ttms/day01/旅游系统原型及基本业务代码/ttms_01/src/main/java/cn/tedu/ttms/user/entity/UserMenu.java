package cn.tedu.ttms.user.entity;

import java.io.Serializable;

public class UserMenu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4125457638892015204L;
	/**
	 * 菜单编号
	 */
	private String id;
	/**
	 * 菜单名称
	 */
	private String name;
	/**
	 * 父菜单ID
	 */
	private String parentId;
	/**
	 * 功能全编号
	 */
	private String nodePath;
	/**
	 * 层级
	 */
	private String level;
	/**
	 * 菜单链接
	 */
	private String url;
	/**
	 * 功能描述
	 */
	private String note;
	/**
	 * 顺序号
	 */
	private int sort;
	/**
	 * 图标
	 */
	private String iconName;
	
	/**
	 * 仅图标
	 */
	private String iconOnly;
	
	/**
	 * 有效标志
	 */
	private String valid;
	
	/**
	 * 框架名称
	 */
	private String target;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getNodePath() {
		return nodePath;
	}

	public void setNodePath(String nodePath) {
		this.nodePath = nodePath;
	}
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public String getIconOnly() {
		return iconOnly;
	}

	public void setIconOnly(String iconOnly) {
		this.iconOnly = iconOnly;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
}
