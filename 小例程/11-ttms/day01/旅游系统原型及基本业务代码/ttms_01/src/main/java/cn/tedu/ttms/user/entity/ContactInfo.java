package cn.tedu.ttms.user.entity;

import java.io.Serializable;

public class ContactInfo implements Serializable {
	private static final long serialVersionUID = 6990427699028736688L;
	private String id;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 联系方式
	 */
	private String contactInfo;
	/**
	 * 联系方式区分 (1:电话  2:邮箱)
	 */
	private String contactType;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactDiv) {
		this.contactType = contactDiv;
	}
}