package cn.tedu.ttms.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.user.entity.ContactInfo;
import cn.tedu.ttms.user.entity.Menu;
import cn.tedu.ttms.user.entity.User;
import cn.tedu.ttms.user.entity.UserRole;


public interface UserMapper {

	/**
	 * 查询用户信息
	 * @param user
	 * @param pageObj
	 * @return
	 */
	List<User> selectUser(@Param(value = "user")User user, @Param(value = "pageObj")PageObject pageObj);
	
	/**
	 * 查询用户信息列表
	 * @param user
	 * @param pageObj
	 * @return
	 */
	List<User> selectUserList(@Param(value = "user")User user, @Param(value = "pageObj")PageObject pageObj);
	/**
	 * 查询用户类别列表
	 * @param user
	 * @param pageObj
	 * @return
	 */
	List<User> selectUserClass(@Param(value = "user")User user, @Param(value = "pageObj")PageObject pageObj);
	/**
	 * 查询用户属性列表
	 * @param user
	 * @param pageObj
	 * @return
	 */
	
	List<User> selectUserType(@Param(value = "user")User user, @Param(value = "pageObj")PageObject pageObj);
	/**
	 * 查询用户属性列表
	 * @param user
	 * @param pageObj
	 * @return
	 */
	String selectUserOrgName(@Param(value = "id")String id);
	/**
	 * 查询用户属性列表
	 * @param user
	 * @param pageObj
	 * @return
	 */
	String selectUserGrpName(@Param(value = "id")String id);
	/**
	 * 查询用户权限(所有)列表
	 * @param user
	 * @param pageObj
	 * @return
	 */
	
	List<User> selectUserRole(@Param(value = "user")User user, @Param(value = "pageObj")PageObject pageObj);
	/**
	 * 查询用户权限角色列表
	 * @param user
	 * @param pageObj
	 * @return
	 */
	List<User> selectUserRoleName(@Param(value = "id")String id);
	
	/**
	 * 取得数据条数
	 * @param user
	 * @return
	 */
	public int GetRecordCount(@Param(value = "user")User user);
	
	/**
	 * 新增用户信息
	 * @param user
	 * @return
	 */
	int addUser(@Param(value = "user")User user);
	
	/**
	 * 验证用户Id
	 * @param user
	 * @return
	 */
	int checkUserId(String userName);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	int updateUser(@Param(value = "user")User user);
	/**
	 * 更新用户启用信息
	 * @param user
	 * @return
	 */
	int updateUserValid(@Param(value = "user")User user);
	
	/**
	 * 更新用户权限信息(新增时)
	 * @param user
	 * @return
	 */
	int updateUserRole(@Param(value = "user")User user);
	/**
	 * 更新用户权限信息
	 * @param user
	 * @return
	 */
	int updateUserRole2(@Param(value = "user")User user);
	
	/**
	 * 更新用户权限信息
	 * @param user
	 * @return
	 */
	int delUpdateUserRole(@Param(value = "userIds")List<String> userIds);
	
	
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	int deleteUser(@Param(value = "userIds")List<String> userIds);
	
	/**
	 * 删除用户信息
	 * @param userName
	 * @return
	 */
	int delUser(@Param(value = "userName")String userName);
	
	/**
	 * 取得用户联系方式
	 * @param userName
	 * @return
	 */
	List<ContactInfo> selectContactInfo(@Param(value="contactInfo")ContactInfo contactInfo);
	
	/**
	 * 删除用户联系方式 
	 * @param contactInfo
	 * @return
	 */
	int delContactInfo(@Param(value="contactInfo") ContactInfo contactInfo);
	
	/**
	 * 批量新增联系方式
	 * @param contactInfo
	 * @return
	 */
	int addContactInfo(@Param(value="contactInfo") ContactInfo contactInfo);
	
	/**
	 * 新增用户角色
	 * @param userRole
	 * @return
	 */
	int addUserRole(@Param(value="userRole") UserRole userRole);
	
	/**
	 * 删除用户角色
	 * @param userName
	 * @return
	 */
	int delUserRole(@Param(value="userName") String userName);
	
	/**
	 * 取得用户的权限菜单
	 * @return
	 */
	List<UserRole> selectRoleByUser(@Param(value="userName") String userName);
	
	/**
	 * 取得用户的权限菜单
	 * @param userName
	 * @return
	 */
	List<Menu> selectMenuByUser(@Param(value="userName") String userName);

	String selOrgId(@Param(value="id")String id);

	/**
	 * 查询项目经理信息
	 */
	List<Map<String, Object>> findProjectManagers();

	/**
	 * 根据id查询产品经理姓名
	 */
	String getMgrNameById(Integer prodMgrId);


}
