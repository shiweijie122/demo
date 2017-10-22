package cn.tedu.ttms.user.entity;


import java.util.Date;
import java.util.List;

import cn.tedu.ttms.base.entity.BaseModel;


public class User extends BaseModel{
	private static final long serialVersionUID = 1L;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 用户名称
	 */
	private String name;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 确认密码
	 */
	private String repassword;
	/**
	 *部门编号(所属机构编号)
	 */
	private String grpIds;
	/**
	 *部门名称
	 */
	private String grpName;
	/**
	 *所属组织(公司)
	 */
	private String orgIds;
	/**
	 *所属组织(公司)名称
	 */
	private String orgName;
	/**
	 *用户属性
	 */
	private String userType;
	/**
	 *用户属性名
	 */
	private String userTypeName;
	/**
	 *用户类别
	 */
	private String userClass;
	/**
	 *用户类别名
	 */
	private String userClassName;
	/**
	 *最大用户Id(用于拼接用户Id)
	 */
	private int maxUserId;
	/**
	 *注册日期
	 */
	private Date regDate;
	/**
	 *电子邮箱
	 */
	private String eMail;
	/**
	 *电话
	 */
	private String phone;
	/**
	 *备注
	 */
	private String note;
	/**
	 *有效标志
	 */
	private String valid;
	/**
	 * 新增操作的用户
	 */
	private String createdUser;
	/**
	 * 新增操作的时间
	 */
	private Date createdTime;
	/**
	 * 更新操作的用户
	 */
	private String modifiedUser;
	/**
	 * 更新操作的时间
	 */
	private Date modifiedTime;	
	
	/**
	 *万能查询
	 */
	private String selectData;
	/**
	 *修改或添加
	 */
	private int optType;

	/**
	 * 联系方式
	 */
	List<ContactInfo> contactLst;
	/**
	 *权限角色名
	 */
	private String roleName;
	/**
	 *权限Id
	 */
	private String roleId;
	
	private int role;	
	private String nickName;
	private String sex;
	private String birthday;
	
	private String deptNames;
	
	public String getDeptNames() {
		return deptNames;
	}
	public void setDeptNames(String deptNames) {
		this.deptNames = deptNames;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getSelectData() {
		return selectData;
	}
	public void setSelectData(String selectData) {
		this.selectData = selectData;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getOptType() {
		return optType;
	}
	public void setOptType(int optType) {
		this.optType = optType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGrpIds() {
		return grpIds;
	}
	public void setGrpIds(String grpIds) {
		this.grpIds = grpIds;
	}
	public String getGrpName() {
		return grpName;
	}
	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}
	public String getOrgIds() {
		return orgIds;
	}
	public void setOrgIds(String orgIds) {
		this.orgIds = orgIds;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserClass() {
		return userClass;
	}
	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public List<ContactInfo> getContactLst() {
		return contactLst;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public void setContactLst(List<ContactInfo> contactLst) {
		this.contactLst = contactLst;
	}
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	public String getUserClassName() {
		return userClassName;
	}
	public void setUserClassName(String userClassName) {
		this.userClassName = userClassName;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public int getMaxUserId() {
		return maxUserId;
	}
	public void setMaxUserId(int maxUserId) {
		this.maxUserId = maxUserId;
	}
}