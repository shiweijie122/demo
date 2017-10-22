package cn.tedu.ttms.user.service;

import java.util.List;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.user.entity.ContactInfo;
import cn.tedu.ttms.user.entity.Menu;
import cn.tedu.ttms.user.entity.User;
import cn.tedu.ttms.user.entity.UserRole;

public interface UserService {

	/**
	 * 查询用户信息
	 * @return
	 */
	List<User> selectUser(User user, PageObject pageObj) throws Exception;
	
	/**
	 * 查询用户信息列表
	 * @return
	 */
	List<User> selectUserList(User user, PageObject pageObj) throws Exception;
	
	/**
	 * 查询用户类别信息
	 * @return
	 */
	List<User> selectUserClass(User user, PageObject pageObj) throws Exception;
	
	/**
	 * 查询用户属性信息
	 * @return
	 */
	List<User> selectUserType(User user, PageObject pageObj) throws Exception;
	
	/**
	 * 查询用户权限信息
	 * @return
	 */
	List<User> selectUserRole(User user, PageObject pageObj) throws Exception;
	
	/**
	 * 查询用户所属公司名称
	 * @return
	 */
	String selectUserOrgName(String id) throws Exception;
	
	/**
	 * 查询用户所属部门信息
	 * @return
	 */
	String selectUserGrpName(String id) throws Exception;
	
	/**
	 * 查询用户权限信息
	 * @return
	 */
	List<User> selectUserRoleName(String id) throws Exception;
	
	/**
	 * 取得数据条数
	 * @param pageObj
	 * @return
	 */
	public int GetRecordCount(User user) throws Exception;
	
	/**
	 * 更新用户权限信息(角色权限表新增)
	 * @param user
	 * @return
	 */
	int updateUserRole(User user) throws Exception;
	
	/**
	 * 更新用户权限信息(角色权限表更新用户)
	 * @param user
	 * @return
	 */
	int updateUserRole2(User user) throws Exception;
	
	/**
	 * 更新(前需删除)用户权限信息(角色权限表)
	 * @param user
	 * @return
	 */
	int delUpdateUserRole(String userId) throws Exception;
	
	/**
	 * 新增用户信息
	 * @param user
	 * @return
	 */
	int addUser(User user) throws Exception;
	/**
	 * 验证用户Id
	 * @param user
	 * @return
	 */
	int checkUserId(String userName) throws Exception;
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	int updateUser(User user) throws Exception;
	
	/**
	 * 更新用户启用
	 * @param user
	 * @return
	 */
	int updateUserValid(User user) throws Exception;
	
	/**
	 * 更新用户及联系方式
	 * @param user
	 * @param contacts
	 * @return
	 * @throws Exception
	 */
	int updateUser(User user, String contacts) throws Exception;
	
	/**
	 * 删除用户
	 * @param userName
	 * @return
	 */
	int deleteUser(String userId) throws Exception;
	
	/**
	 * 删除用户信息
	 * @param userName
	 * @return
	 */
	int delUser(String userName) throws Exception;
	
	/**
	 * 取得用户联系方式
	 * @param userName
	 * @return
	 */
	List<ContactInfo> selectContactInfo(ContactInfo contactInfo) throws Exception;
	
	
	/**
	 * 新增用户角色
	 * @param userRole
	 * @return
	 */
	int addUserRole(List<UserRole> userRoleList,String userName) throws Exception;
	
	/**
	 * 删除用户角色
	 * @param userName
	 * @return
	 */
	int delUserRole(String userName) throws Exception;
	
	/**
	 * 取得用户的权限菜单
	 * @return
	 */
	List<UserRole> selectRoleByUser(String userName) throws Exception;
	
	/**
	 * 取得用户的权限菜单
	 * @param userName
	 * @return
	 */
	List<Menu> selectMenuByUser(String userName) throws Exception;

	String selOrgId(String id);


}
